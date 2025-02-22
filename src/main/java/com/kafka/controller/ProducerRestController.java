package com.kafka.controller;

import com.kafka.model.ProducerData;
import com.kafka.service.ProducerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "ProducerRestController", description = "The Producer API")
@RequiredArgsConstructor
@Validated
public class ProducerRestController {

    private final ProducerService producerService;

    @SneakyThrows
    @PostMapping("publish")
    public ResponseEntity<Object> publishMessage(@Valid @RequestBody ProducerData data) {
       producerService.publishMessage(data);
        return ResponseEntity.ok().build();
    }
}
