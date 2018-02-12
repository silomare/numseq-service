package io.github.silomare.practice.kafka.numseq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.github.silomare.practice.kafka.numseq.service.KafkaProducer;

@RestController
@RequestMapping(value = "/numproducer")
public class WebRestController {

  @Autowired
  private KafkaProducer producer;

  @RequestMapping(value = "/kafkatopic", method = RequestMethod.POST)
  ResponseEntity<?> sendMessages() {
    producer.sendRange();
    return ResponseEntity.ok().build();
  }
}
