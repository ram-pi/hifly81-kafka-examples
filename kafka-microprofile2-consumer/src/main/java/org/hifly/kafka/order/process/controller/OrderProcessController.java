package org.hifly.kafka.order.process.controller;

import org.hifly.kafka.demo.consumer.deserializer.impl.ConsumerThread;
import org.hifly.kafka.order.process.consumer.handle.OrderProcessHandle;
import org.hifly.kafka.order.process.event.OrderEvent;

public class OrderProcessController {

    private final String TOPIC = "orders";

    public void receiveOrders(int numberOfConsumer, String groupName, int duration, int pollSize) {
        for(int i = 0; i < numberOfConsumer; i++) {
            Thread t = new Thread(
                    new ConsumerThread<String, OrderEvent>(
                            String.valueOf(i),
                            groupName,
                            TOPIC,
                            "org.apache.kafka.common.serialization.StringDeserializer",
                            "org.hifly.kafka.order.process.consumer.OrderEventJsonDeserializer",
                            pollSize,
                            duration,
                            false ,
                            true,
                            true,
                            new OrderProcessHandle()));
            t.start();
        }
    }


}
