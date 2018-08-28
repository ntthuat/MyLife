package com.service;

import com.dao.OrderDao;
import com.dao.OrderDetailDao;
import com.model.Order;
import com.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
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

  @Autowired
  private OrderDetailDao orderDetailDao;

  public List<Order> findAllOrders() {
    return orderDao.findAll();
  }

  public int insertOrder(Order order) {
    order.setIdOrder(findNewIdOrder());
    order.setCreatedDate(findNewDate());
    order.setShippedDate(null);
    order.setStatus("Đã Nhận");
    return orderDao.save(order);
  }

  public Order findLastOrder() {
    return orderDao.findLastOrder();
  }

  public int insertOrderDetail(OrderDetail orderDetail) {
    orderDetail.setIdProduct(findNewIdProduct());
    return orderDetailDao.save(orderDetail);
  }

  private String findNewIdProduct(){
    final String maxId = orderDetailDao.findMaxId();
    int newId_int = Integer.parseInt(maxId);
    newId_int++;
    String newId_String = Integer.toString(newId_int);
    newId_String = ("00000" + newId_String).substring(newId_String.length());
    return newId_String;
  }

  private String findNewIdOrder(){
    final String maxId = orderDao.findMaxId();
    int newId_int = Integer.parseInt(maxId);
    newId_int++;
    String newId_String = Integer.toString(newId_int);
    newId_String = ("0000" + newId_String).substring(newId_String.length());
    return newId_String;
  }

  private Date findNewDate(){
    return new Date(Calendar.getInstance().getTime().getTime());
  }

}
