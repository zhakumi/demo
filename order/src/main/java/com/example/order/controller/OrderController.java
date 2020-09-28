package com.example.order.controller;

import com.example.order.ClientFeign;
import com.example.order.model.OrderFrom;
import com.example.order.services.OrderServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: wangcan
 * @Date: 2020/9/10 10:24
 */
@Slf4j
@RestController
public class OrderController {

  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private OrderServices orderServices;

  @GetMapping("/order")
  public String storage() {
    log.info("invoked order");
//    restTemplate.getForObject("http://account/hello/"+"wangcan", String.class);
    return "order";
  }

  @GetMapping("/insert")
  public String insert() {
    log.info("invoked insert");
    OrderFrom order = new OrderFrom();
    order.setId(0L);
    order.setUserId(1L);
    order.setProductId(1L);
    order.setCount(1);
    order.setMoney(1L);
    order.setStatus(0);
    orderServices.insert(order);
    // 扣减库存
    restTemplate.postForEntity("http://storage/reduce/",null,String.class);
    // 账户扣减
    restTemplate.postForEntity("http://account/reduce/",null,String.class);
    return "order";
  }

}
