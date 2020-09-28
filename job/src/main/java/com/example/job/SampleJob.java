package com.example.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: wangcan
 * @Date: 2020/9/27 17:52
 */
@Component
public class SampleJob {
  private static Logger logger = LoggerFactory.getLogger(SampleJob.class);


  /**
   * 1、简单任务示例（Bean模式）
   */
  @XxlJob("demoJobHandler")
  public ReturnT<String> demoJobHandler(String param) throws Exception {
    XxlJobLogger.log("XXL-JOB, Hello World.");

    for (int i = 0; i < 5; i++) {
      XxlJobLogger.log("beat at:" + i);
      TimeUnit.SECONDS.sleep(2);
    }
    return ReturnT.SUCCESS;
  }

  @XxlJob("testJobHandler")
  public ReturnT<String> testJobHandler(String param) throws Exception {
    XxlJobLogger.log("test");

    for (int i = 0; i < 5; i++) {
      XxlJobLogger.log("beat at:" + i);
      TimeUnit.SECONDS.sleep(2);
    }
    return ReturnT.SUCCESS;
  }

}
