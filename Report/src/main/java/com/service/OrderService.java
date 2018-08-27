package com.service;

import com.dao.OrderDao;
import com.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/08/27 6:56 PM
 * $Log: OrderService.java
 */
@Service
public class OrderService {

  @Autowired
  private OrderDao orderDao;

  public List<Order> findAllOrders() {
    return orderDao.findAll();
  }

  public int insertOrder(Order order) {
    return orderDao.save(order);
  }
}
