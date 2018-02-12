package io.github.silomare.practice.kafka.numseq.service;

import java.util.stream.IntStream;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
  private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

  @Resource(name = "numKafkaTemplate")
  private KafkaTemplate<String, Integer> kafkaTemplate;

  @Value("${kafka.topic.input}")
  private String kafkaTopic;

  private int rangeEnd = 100;

  public void sendRange() {
    log.info("generating numbers to fizzbuzz ...");
    // Stream.iterate(1, n -> n + 1).limit(100).forEach(n ->
    // kafkaTemplate.send(kafkaTopic, n));
    IntStream.rangeClosed(1, this.rangeEnd).forEach(n -> kafkaTemplate.send(kafkaTopic, n));
  }
}
