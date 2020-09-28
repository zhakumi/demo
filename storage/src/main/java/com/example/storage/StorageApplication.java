package com.example.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: wangcan
 * @Date: 2020/9/10 10:58
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.example.storage")
@MapperScan("com.example.storage.mapper")
public class StorageApplication {
  public static void main(String[] args) {
    SpringApplication.run(StorageApplication.class, args);
  }
}
