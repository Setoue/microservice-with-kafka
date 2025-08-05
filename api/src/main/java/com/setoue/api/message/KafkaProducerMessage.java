package com.setoue.api.message;

import com.setoue.api.dto.CarPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerMessage {

    @Autowired
    private KafkaTemplate<String, CarPostDto> kafkaTemplate;

    // Final method to send a message to an Apache Kafka topic - Created
    public void sendMessage(CarPostDto carPostDto){
        String KAFKA_TOPIC = "car-post-topic";
        kafkaTemplate.send(KAFKA_TOPIC, carPostDto);
    }

}
