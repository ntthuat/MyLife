package com.cronjob.aspect;

import com.cronjob.util.DateTimeUtil;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/08/23 10:07 AM
 * $Log: PerformanceAspect.java
 */
@Component
@EnableScheduling
public class PerformanceAspect {
  private final static Logger logger = Logger.getLogger(PerformanceAspect.class);

  private final static Date startDate = new Date();

  @Scheduled(cron = "${app.cron.ranTime}")
  public void measureAPI() {
    Date nowDate = new Date();
    logger.debug("CronJob ran in " + DateTimeUtil.getDifference(startDate, nowDate));
  }
}
