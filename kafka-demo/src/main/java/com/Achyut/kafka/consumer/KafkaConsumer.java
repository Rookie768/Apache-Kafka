package com.Achyut.kafka.consumer;

import com.Achyut.kafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

   // @KafkaListener(topics = "Achyut", groupId = "my-group")
    public void ConsumeMessage(String msg){
        log.info(String.format("message sent successfully :: %s",msg));

    }
    @KafkaListener(topics = "Achyut", groupId = "my-group")
    public void ConsumeJsonMessage(Student student){
        log.info(String.format("message sent successfully :: %s",student.toString()));

    }
}
