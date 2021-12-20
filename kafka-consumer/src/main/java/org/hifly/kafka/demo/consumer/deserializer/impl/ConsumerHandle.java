package org.hifly.kafka.demo.consumer.deserializer.impl;

import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.hifly.kafka.demo.consumer.deserializer.AbstractConsumerInstance;
import org.hifly.kafka.demo.consumer.deserializer.ConsumerRecordUtil;

public class ConsumerHandle<K,V> extends AbstractConsumerInstance<K,V> {

    private List<String> valueStore;
    private Map<TopicPartition, OffsetAndMetadata> offsets;

    public ConsumerHandle(List<String> valueStore) {
        this.valueStore = valueStore;
    }

    public List<String> getValueStore() {
        return valueStore;
    }

    public void addOffsets(Map<TopicPartition, OffsetAndMetadata> offsets) {
        this.offsets = offsets;
    }

    @Override
    public void process(ConsumerRecords<K, V> consumerRecords, String groupId) {
        for (ConsumerRecord<K, V> record : consumerRecords) {
            ConsumerRecordUtil.prettyPrinter(groupId,  record);
            if(valueStore != null)
                valueStore.add(String.valueOf(record.value()));
            if(offsets != null)
                //store next offset to commit
                offsets.put(new TopicPartition(record.topic(), record.partition()), new OffsetAndMetadata(record.offset() + 1, "null"));
        }
    }
}
