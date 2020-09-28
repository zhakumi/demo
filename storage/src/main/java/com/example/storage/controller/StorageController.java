package com.example.storage.controller;

import com.example.storage.mapper.StorageMapper;
import com.example.storage.model.Storage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangcan
 * @Date: 2020/9/10 11:03
 */
@Slf4j
@RestController
public class StorageController {

  @Autowired
  private StorageMapper storageMapper;

  @PutMapping("/hello/{name}")
  public String storage(@PathVariable String name) {
    log.info("invoked"+name);
    return "hello"+name;
  }

  /**
   * 扣减库存
   * @return
   */
  @PostMapping("/reduce")
  public int reduce() {
    log.info("invoked reduce");
    Storage storage = new Storage();
    storage.setId(1L);
    storage.setProductId(1L);
    storage.setTotal(10);
    storage.setUsed(2);
    storage.setResidue(0);
    return storageMapper.insert(storage);
  }
}
