package org.hifly.kafka.demo.streams.stream;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.Branched;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Named;
import org.apache.kafka.streams.kstream.Produced;
import org.hifly.kafka.demo.streams.CarInfo;
import org.hifly.kafka.demo.streams.serializer.CarInfoDeserializer;
import org.hifly.kafka.demo.streams.serializer.CarInfoSerializer;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class CarBrandStream {

    private static final String BROKER_LIST =
            System.getenv("kafka.broker.list") != null ? System.getenv("kafka.broker.list") : "localhost:9092,localhost:9093,localhost:9094";

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "carbrand_app_id");
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        properties.put(StreamsConfig.STATE_DIR_CONFIG, "/tmp/streams-cars");


        final String inputTopic = "input-topic";
        final String ferrariTopic = "ferrari-topic";
        final String carsTopic = "cars-topic";

        CarBrandStream carBrandStream = new CarBrandStream();

        KafkaStreams kafkaStreams =
                new KafkaStreams(carBrandStream.createTopology(inputTopic, ferrariTopic, carsTopic), properties);
        final CountDownLatch latch = new CountDownLatch(1);

        // SIGTERM
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                kafkaStreams.close();
                latch.countDown();
            } catch (final Exception e) {
            }
        }));

        try {
            kafkaStreams.start();
            latch.await();
        } catch (Throwable e) {
            System.exit(1);
        }
        System.exit(0);

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
        builder.stream(inputTopic, Consumed.as("Cars_input_topic").with(Serdes.String(), Serdes.String()))
                .peek((key, value) -> System.out.println("Incoming record - key " +key +" value " + value))
                .mapValues(car -> {
                    try {
                        return mapper.readValue(car, CarInfo.class);
                    } catch (Exception e) {
                        throw new RuntimeException("Can't generate the ktable" + e);
                    }
                }, Named.as("Cars_map_values"))
                .peek((key, value) -> System.out.println("Outgoing record - key " +key +" value " + value))
                .split()
                .branch(
                        (key, value) -> "Ferrari".equalsIgnoreCase(value.getBrand()),
                        Branched.withConsumer(ks -> ks.to(ferrariTopic, Produced.as("Ferrari_output_topic").with(Serdes.String(), carInfoSerde))))
                .branch(
                        (key, value) -> true,
                        Branched.withConsumer(ks -> ks.to(carsTopic, Produced.as("Cars_output_topic").with(Serdes.String(), carInfoSerde))));

        return builder.build();
    }

}
