package com.cronjob.service;

import com.cronjob.dao.StockDao;
import com.cronjob.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/09/27 11:46 AM
 * $Log: StockService.java
 */
@Service
public class StockService {

  @Autowired
  private StockDao stockDao;

  public List<Stock> findAllStockNasdaq() {
    return stockDao.findAllNasdaq();
  }
}
