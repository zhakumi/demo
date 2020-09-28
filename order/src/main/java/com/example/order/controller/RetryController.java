package com.example.order.controller;

import io.swagger.models.auth.In;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangcan
 * @Date: 2020/9/27 15:25
 */
@RestController
// 启用重试
@EnableRetry
public class RetryController {
  AtomicInteger num = new AtomicInteger(0);
  @GetMapping("/retry_test")
  @Retryable(value = {Exception.class}, maxAttempts = 4, backoff = @Backoff(delay = 1000, maxDelay = 2))
  public Integer test() {
    System.out.println("测试" + num.incrementAndGet()+new Date());
    int a = 1 / 0;
    return 1;
  }
}
