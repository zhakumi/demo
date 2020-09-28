package com.example.account.services;

import com.example.account.model.Account;

/**
 * @Author: wangcan
 * @Date: 2020/9/10 13:58
 */
public interface AccountServices {
  int insert(Account record);

  int update(Account record);
}
