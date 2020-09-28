package com.example.account.services.impl;

import com.example.account.mapper.AccountMapper;
import com.example.account.model.Account;
import com.example.account.services.AccountServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wangcan
 * @Date: 2020/9/10 14:00
 */
@Service
public class AccountServicesImpl implements AccountServices {

  private static final Logger LOGGER = LoggerFactory.getLogger(AccountServicesImpl.class);
  @Autowired
  private AccountMapper accountMapper;

  @Override
  public int insert(Account record) {
    return accountMapper.insert(record);
  }

  @Override
  public int update(Account record) {
    return accountMapper.updateByPrimaryKey(record);
  }
}
