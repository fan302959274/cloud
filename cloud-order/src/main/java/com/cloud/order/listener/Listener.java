package com.cloud.order.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


    @KafkaListener(topics = {"ORDER_NOTIFY"})
    public void listen(ConsumerRecord<?, ?> record) {

        logger.info("kafka的topic: " + record.topic());
        logger.info("kafka的key: " + record.key());
        logger.info("kafka的value: " + record.value().toString());
    }

}