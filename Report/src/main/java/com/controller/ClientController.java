package com.controller;

import com.service.ClientService;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by: tnthien
 * $Revision: 1.0 $Date: 2018/08/25 3:28 PM
 * $Log: ClientController.java
 */
@Controller
@RequestMapping("/client")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @GetMapping("/client-all")
  public String allClients(Model model) {
    List clients = clientService.findAllClients();
    model.addAttribute("clients", clients);
    return "client-all";
  }
}
