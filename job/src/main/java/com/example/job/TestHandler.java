package com.example.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import org.springframework.stereotype.Component;

/**
 * @Author: wangcan
 * @Date: 2020/9/27 18:26
 */

@Component
public class TestHandler extends IJobHandler {

  @Override
  public ReturnT<String> execute(String param) throws Exception {
    System.out.println("执行了TestHandler一次");        return SUCCESS;
  }
}
