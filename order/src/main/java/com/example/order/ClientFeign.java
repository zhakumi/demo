package com.example.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: wangcan
 * @Date: 2020/9/10 16:34
 */
@FeignClient(value = "service-hi", fallback = HystrixClientFeign.class)
public interface ClientFeign {

  @GetMapping("/hello")
  String getHello(@RequestParam(value = "name") String name);
}
