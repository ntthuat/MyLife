package com.cronjob.controller;

import com.cronjob.service.StockService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/09/27 11:47 AM
 * $Log: StockController.java
 */
@Controller
@EnableScheduling
public class StockController {

  private static final Logger logger = Logger.getLogger(StockController.class);

  @Autowired
  private StockService stockService;

  @Scheduled(cron = "${app.cron.stock}")
  public String test(){
    System.out.println("Phương Đẹp Gái");
    logger.info("info log");
    logger.debug("debug log");
    logger.error("error log");
    logger.trace("trace log");
    stockService.findAllStockNasdaq();
    return "DONE";
  }
}
