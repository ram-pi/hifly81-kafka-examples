package org.hifly.kafka.demo.streams.stream;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.streams.kstream.Branched;
import org.hifly.kafka.demo.streams.CarInfo;
import org.hifly.kafka.demo.streams.serializer.CarInfoDeserializer;
import org.hifly.kafka.demo.streams.serializer.CarInfoSerializer;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Properties;

public class CarBrandStream {

    private static final String BROKER_LIST =
            System.getenv("kafka.broker.list") != null ? System.getenv("kafka.broker.list") : "localhost:9092,localhost:9093,localhost:9094";

    public void startStream(Properties properties,
                            String inputTopic, String ferrariTopic,
                            String carsTopic) {
        if (properties.getProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG) == null)
            properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "carbrand_app_id");
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

        KafkaStreams kafkaStreams = 
            new KafkaStreams(createTopology(inputTopic, ferrariTopic, carsTopic), properties);
        kafkaStreams.start();

        // SIGTERM
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                kafkaStreams.close();
            } catch (final Exception e) {
            }
        }));

    }

    public Topology createTopology(
            String inputTopic,
            String ferrariTopic,
            String carsTopic) {

        StreamsBuilder builder = new StreamsBuilder();

        ObjectMapper mapper = new ObjectMapper();

        final Serializer<CarInfo> carInfoSerializer = new CarInfoSerializer();
        final Deserializer<CarInfo> carInfoDeserializer = new CarInfoDeserializer();
        final Serde<CarInfo> carInfoSerde = Serdes.serdeFrom(carInfoSerializer, carInfoDeserializer);

        //group data by car brand
        builder.stream(
                inputTopic,
                Consumed.with(Serdes.String(), Serdes.String()))
                .map((carId, car) -> {
                    try {
                        CarInfo carInfo = mapper.readValue(car, CarInfo.class);
                        return new KeyValue<>(carId, carInfo);
                    } catch (Exception e) {
                        throw new RuntimeException("Can't generate the kstream" + e);
                    }
                })
                .split()
                .branch(
                        (key, value) -> "Ferrari".equalsIgnoreCase(value.getBrand()),
                        Branched.withConsumer(ks -> ks.to(ferrariTopic)))
                .branch(
                        (key, value) -> true,
                        Branched.withConsumer(ks -> ks.to(carsTopic)));

        return builder.build();
    }

}
