package com.dao;

import com.model.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/08/28 3:55 PM
 * $Log: OrderDetailDaoTest.java
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderDetailDaoTest {

  @Autowired
  private OrderDetailDao orderDetailDao;

  @Test
  public void findAllByIdOrder(){
    String id = "0001";
    List<OrderDetail> list = orderDetailDao.findAllByIdOrder(id);
    System.out.println(list.size());
  }
}
