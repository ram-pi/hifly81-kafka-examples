package org.hifly.kafka.demo.consumer.partition;

import org.hifly.kafka.demo.consumer.offset.OffsetManager;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.util.Collection;
import java.util.Map;
import java.util.Properties;

public class PartitionListener<T> implements ConsumerRebalanceListener {

    private Consumer<String, T> consumer;
    private Map<TopicPartition, OffsetAndMetadata> offsets;

    public PartitionListener(Consumer<String, T> consumer, Map<TopicPartition, OffsetAndMetadata> offsets) {
        this.consumer = consumer;
        this.offsets = offsets;
    }

    @Override
    public void onPartitionsRevoked(Collection<TopicPartition> collection) {

    }

    @Override
    public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
        Properties properties = OffsetManager.load();
        //seek from offset
        for (TopicPartition partition : partitions) {
            try {
                String offset = properties.getProperty(partition.topic() + "-" + partition.partition());
                if (offset != null) {
                    consumer.seek(partition, Long.valueOf(offset));
                    System.out.printf("Consumer - partition %s - initOffset %s\n", partition.partition(), offset);
                }
            } catch (Exception ex) {
                //Ignore
            }

        }
    }

}
