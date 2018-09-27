package com.cronjob.dao;

import com.cronjob.model.Stock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/09/27 11:34 AM
 * $Log: StockDaoTest.java
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StockDaoTest {

  @Autowired
  private StockDao stockDao;

  @Test
  public void findAllNasdaqTest(){
    List<Stock> list = stockDao.findAllNasdaq();
    System.out.println(list.size());
  }
}
