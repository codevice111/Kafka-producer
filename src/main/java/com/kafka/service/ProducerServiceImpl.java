package com.kafka.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.model.ProducerData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerServiceImpl implements ProducerService {

    @Value("${spring.kafka.topic}")
    private String topic;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void publishMessage(ProducerData data) throws Exception {
        log.info("Message published to topic: {} -> {}", topic, data);
        kafkaTemplate.send(topic, null, new ObjectMapper().writeValueAsString(data));
    }
}
