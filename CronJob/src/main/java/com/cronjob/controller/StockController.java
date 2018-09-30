package com.cronjob.controller;

import com.cronjob.service.StockService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/09/27 11:47 AM
 * $Log: StockController.java
 */
@Controller
public class StockController {

  private static final Logger logger = Logger.getLogger(StockController.class);

  @Autowired
  private StockService stockService;

}
