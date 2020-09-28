package com.example.order;

import org.springframework.stereotype.Component;

/**
 * @Author: wangcan
 * @Date: 2020/9/10 16:35
 */

@Component
public class HystrixClientFeign implements ClientFeign{

  @Override
  public String getHello(String name) {
    return "hello " + name + ", error!";
  }

}
