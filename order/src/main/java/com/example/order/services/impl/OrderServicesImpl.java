package com.example.order.services.impl;

import com.example.order.mapper.OrderFromMapper;
import com.example.order.model.OrderFrom;
import com.example.order.services.OrderServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wangcan
 * @Date: 2020/9/10 14:00
 */
@Service
public class OrderServicesImpl implements OrderServices {
  private static final Logger LOGGER = LoggerFactory.getLogger(OrderServicesImpl.class);
  @Autowired
  private OrderFromMapper orderFromMapper;



  @Override
  public int insert(OrderFrom record) {
    //创建订单
    return orderFromMapper.insert(record);
  }
}
