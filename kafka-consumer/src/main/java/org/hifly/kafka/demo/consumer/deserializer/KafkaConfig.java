package org.hifly.kafka.demo.consumer.deserializer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class KafkaConfig {

    private static final String BROKER_LIST =
            System.getenv("kafka.broker.list") != null? System.getenv("kafka.broker.list") :"localhost:9092,localhost:9093,localhost:9094";

    public static Properties loadConfig(final String configFile) throws IOException {
        if (!Files.exists(Paths.get(configFile))) {
            throw new IOException(configFile + " not found.");
        }
        final Properties cfg = new Properties();
        try (InputStream inputStream = new FileInputStream(configFile)) {
            cfg.load(inputStream);
        }

        return cfg;
    }


    public static Properties consumerConfig(String groupId, String keyDeserializerClassName, String valueDeserializerClassName, boolean autoCommit) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", BROKER_LIST);
        properties.put("group.id", groupId);
        properties.put("key.deserializer", keyDeserializerClassName);
        properties.put("value.deserializer", valueDeserializerClassName);
        properties.put("enable.auto.commit", String.valueOf(autoCommit));
        properties.put("auto.offset.reset", "earliest");
        properties.put("max.poll.interval.ms", 300000);

        return properties;
    }


}
