package com.kafka.service;

import com.kafka.model.ProducerData;

public interface ProducerService {
    void publishMessage(ProducerData data) throws Exception;
}
