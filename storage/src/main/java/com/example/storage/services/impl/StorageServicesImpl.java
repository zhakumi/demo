package com.example.storage.services.impl;
import com.example.storage.mapper.StorageMapper;
import com.example.storage.model.Storage;
import com.example.storage.services.StorageServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wangcan
 * @Date: 2020/9/10 14:00
 */
@Service
public class StorageServicesImpl implements StorageServices {
  private static final Logger LOGGER = LoggerFactory.getLogger(StorageServicesImpl.class);
  @Autowired
  private StorageMapper storageMapper;

  @Override
  public int insert(Storage record) {
    return storageMapper.insert(record);
  }
}
