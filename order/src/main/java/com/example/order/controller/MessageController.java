package com.example.order.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangcan
 * @Date: 2020/9/27 14:14
 */
@RestController
public class MessageController {
  @Autowired
  private KafkaTemplate<String,Object> kafkaTemplate;

  @GetMapping("/message/send")
  public boolean send(){
    kafkaTemplate.send("testTopic","aaaa");
    return true;
  }

}
