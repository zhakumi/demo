package com.example.order.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @Author: wangcan
 * @Date: 2020/9/27 14:19
 */
@Component
public class ConsumerListener {
  @KafkaListener(topics = "testTopic")
  public void onMessage(String message){
    //insertIntoDb(buffer);//这里为插入数据库代码
    System.out.println(message);
  }
}
