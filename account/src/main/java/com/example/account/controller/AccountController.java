package com.example.account.controller;

import com.example.account.model.Account;
import com.example.account.services.AccountServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangcan
 * @Date: 2020/9/10 11:06
 */
@Slf4j
@RestController
public class AccountController {
  @Autowired
  private AccountServices accountServices;
  @GetMapping("/hello/{name}")
  public String storage(@PathVariable String name) {
    log.info("invoked hello"+name);
    return "hello account";
  }


  @PostMapping("/reduce")
  public int reduce(Account account) {
    log.info("invoked reduce");
    Account account1=new Account();
    account1.setId(1L);
    account1.setUserId(1L);
    account1.setTotal(100L);
    account1.setUsed(40L);
    account1.setResidue(60L);
    return accountServices.update(account1);
  }

}
