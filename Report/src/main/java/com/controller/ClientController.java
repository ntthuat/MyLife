package com.controller;

import com.model.Client;
import com.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

  @GetMapping("/client-new")
  public String createClient(Model model) {
    model.addAttribute("client", new Client());
    return "client-new";
  }

  @PostMapping("/client-new")
  public String createClient(@ModelAttribute Client client) {
    clientService.insertClient(client);
    return "client-new-result";
  }
}
