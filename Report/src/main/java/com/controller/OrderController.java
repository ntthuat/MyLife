package com.controller;

import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/08/27 6:58 PM
 * $Log: OrderController.java
 */
@Controller
@RequestMapping("/order")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @GetMapping("/order-all")
  public String allOrders(Model model) {
    List orders = orderService.findAllOrders();
    model.addAttribute("orders", orders);
    return "order/order-all";
  }
}
