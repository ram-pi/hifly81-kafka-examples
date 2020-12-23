package com.redhat.kafka.demo.consumer;

import com.redhat.kafka.demo.consumer.handle.ConsumerHandle;
import com.redhat.kafka.demo.consumer.offset.OffsetManager;
import com.redhat.kafka.demo.consumer.partition.PartitionListener;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.errors.WakeupException;

import java.time.Duration;
import java.util.*;

public class BaseConsumer<T> implements BaseKafkaConsumer {

    private Map<TopicPartition, OffsetAndMetadata> offsets = new HashMap<>();
    private Consumer<String, T> consumer;
    private ConsumerHandle consumerHandle;
    private Properties properties;
    private String id;
    private String groupId;
    private boolean autoCommit;

    public BaseConsumer(String id, Properties properties, ConsumerHandle consumerHandle) {
        this.id = id;
        this.properties = properties;
        this.consumerHandle = consumerHandle;
    }

    @Override
    public void subscribe(String groupId, String topic, boolean autoCommit) {
        consumer = new KafkaConsumer<>(
                KafkaConfig.baseConsumerConfig(groupId, properties.getProperty("desererializerClass"), autoCommit));
        consumer.subscribe(Collections.singletonList(topic), new PartitionListener(consumer, offsets));
        this.autoCommit = autoCommit;
        this.groupId = groupId;
    }

    @Override
    public boolean assign(String topic, List partitions, boolean autoCommit) {
        boolean isAssigned = false;
        consumer = new KafkaConsumer<>(
                KafkaConfig.baseConsumerConfig("", properties.getProperty("desererializerClass"), autoCommit));
        List<PartitionInfo> partitionsInfo = consumer.partitionsFor(topic);
        Collection<TopicPartition> partitionCollection = new ArrayList<>();
        if (partitionsInfo != null) {
            for (PartitionInfo partition : partitionsInfo) {
                if (partitions == null || partitions.contains(partition.partition()))
                    partitionCollection.add(new TopicPartition(partition.topic(), partition.partition()));
            }
            if (!partitionCollection.isEmpty()) {
                consumer.assign(partitionCollection);
                isAssigned = true;
            }
        }
        this.autoCommit = autoCommit;
        return isAssigned;
    }

    @Override
    public void poll(int timeout, long duration, boolean commitSync) {
        final Thread mainThread = Thread.currentThread();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.printf("Starting exit...\n");
            consumer.wakeup();
            try {
                mainThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                // Restore interrupted state...
                Thread.currentThread().interrupt();
            }
        }));

        if (consumer == null)
            throw new IllegalStateException("Can't poll, consumer not subscribed or null!");

        try {
            if(duration == -1) {
                while (true) {
                    consume(timeout, commitSync);
                }
            } else {
                long startTime = System.currentTimeMillis();
                while(false||(System.currentTimeMillis()-startTime) < duration) {
                    consume(timeout, commitSync);
                }
            }
        }
        catch (WakeupException e) {
        // ignore for shutdown
        }
        finally {
            try {
                //print offsets
                //sync does retries, we want to use it in case of last commit or rebalancing
                consumer.commitSync();
                for (Map.Entry<TopicPartition, OffsetAndMetadata> entry : offsets.entrySet())
                    System.out.printf("Consumer %s - partition %s - lastOffset %s\n", this.id, entry.getKey().partition(), entry.getValue().offset());
                //Store offsets
                OffsetManager.store(offsets);
            } finally {
                consumer.close();
                System.out.printf("Bye Bye...\n");
            }
        }

    }

    private void consume(int timeout, boolean commitSync) {
        ConsumerRecords<String, T> records = consumer.poll(Duration.ofMillis(timeout));
        consumerHandle.addOffsets(offsets);
        consumerHandle.process(records);

        if (!autoCommit)
            if(!commitSync) {
                try {
                    //async doesn't do a retry
                    consumer.commitAsync((map, e) -> {
                        if (e != null)
                            e.printStackTrace();
                    });
                } catch (CommitFailedException e) {
                    e.printStackTrace();
                }
            } else {
                consumer.commitSync();
            }
    }


}
