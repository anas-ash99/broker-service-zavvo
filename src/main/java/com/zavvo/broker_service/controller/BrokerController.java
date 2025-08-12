package com.zavvo.broker_service.controller;

import com.zavvo.broker_service.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class BrokerController {


    @Autowired
    private KafkaProducer kafkaProducer;


    @PostMapping("/{topic}")
    public ResponseEntity<Void> createMessage(@RequestBody String message, @PathVariable String topic){
        System.out.println(message);
        kafkaProducer.publishMessage(topic, message);
        return ResponseEntity.ok(null);
    }
    @GetMapping
    public String home(){
        return "Welcome to broker service";
    }

}
