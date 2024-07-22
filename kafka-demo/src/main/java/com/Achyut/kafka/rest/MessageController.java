package com.Achyut.kafka.rest;

import com.Achyut.kafka.payload.Student;
import com.Achyut.kafka.producer.KafkaJsonProducer;
import com.Achyut.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/messages")
public class MessageController {
    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String msg){
         kafkaProducer.sendMessage(msg);
         return ResponseEntity.ok("message sent successfully");
    }
    @PostMapping("/json")
    public ResponseEntity<String> sendMessage(@RequestBody Student msg){
        kafkaJsonProducer.sendMessage(msg);
        return ResponseEntity.ok("message sent successfully");
    }
}
