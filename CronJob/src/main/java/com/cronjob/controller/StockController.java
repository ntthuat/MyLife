package com.cronjob.controller;

import com.cronjob.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/09/27 11:47 AM
 * $Log: StockController.java
 */
@Controller
public class StockController {

  @Autowired
  private StockService stockService;

  @Scheduled(cron = "${app.cron.stock}")
  public String test(){
    System.out.println("Thuat Dep Trai");
    return "DONE";
  }
}
