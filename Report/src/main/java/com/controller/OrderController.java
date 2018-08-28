package com.controller;

import com.model.Client;
import com.model.Order;
import com.model.OrderDetail;
import com.service.ClientService;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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

  @Autowired
  private ClientService clientService;

  @GetMapping("/order-all")
  public String allOrders(Model model) {
    List orders = orderService.findAllOrders();
    model.addAttribute("orders", orders);
    return "order/order-all";
  }

  @GetMapping("/order-new")
  public String createOrder(Model model) {
    model.addAttribute("order", new Order());
    return "order/order-new";
  }

  @PostMapping("/order-new")
  public String createOrder(@ModelAttribute Order order, Model model) {
    orderService.insertOrder(order);
    Client client = clientService.findClientById(order.getIdClient());
    model.addAttribute("client", client);
    return "order/order-new-result";
  }

/*  @GetMapping("/order-new-result")
  public String createOrderResult(@ModelAttribute Order order) {
    System.out.println("/order-new-result");
    System.out.println(order.getIdOrder());
    return "order/order-new-result";
  }*/

  @GetMapping("/orderDetail-new")
  public String createOrderDetail(Model model) {
    //TODO: cần tìm hiểu cách để giữ lại được cái order
    //TODO: https://www.intertech.com/Blog/understanding-spring-mvc-model-and-session-attributes/
    Order order = orderService.findLastOrder();
    model.addAttribute("order", order);
    model.addAttribute("orderDetail", new OrderDetail());
    return "order/orderDetail-new";
  }

  @PostMapping("/orderDetail-new")
  public String createOrderDetail(@ModelAttribute OrderDetail orderDetail, Model model) {
    Order order = orderService.findLastOrder(); //TODO: cần tìm hiểu cách để giữ lại được cái order
    orderDetail.setIdOrder(order.getIdOrder());
    orderService.insertOrderDetail(orderDetail);
    order.setTotalPrice(getTotalPrice(orderDetail)); //TODO: refactor code here
    model.addAttribute("order", order);
    model.addAttribute("orderDetail", orderDetail);

    final Client client = clientService.findClientById(order.getIdClient());
    model.addAttribute("client", client);

    return "order/orderDetail-new-result";
    /*return "order/orderDetail-new";*/ //TODO: chỗ này thêm sản phẩm, làm saus
  }

  private BigDecimal getTotalPrice(OrderDetail orderDetail){
    return calculateCost(orderDetail.getQuantity(), orderDetail.getUnitPrice());
  }

  BigDecimal itemCost  = BigDecimal.ZERO;
  BigDecimal totalCost = BigDecimal.ZERO;

  public BigDecimal calculateCost(Integer itemQuantity, BigDecimal itemPrice)
  {
    itemCost  = itemPrice.multiply(new BigDecimal(itemQuantity));
    totalCost = totalCost.add(itemCost);
    return totalCost;
  }

}
