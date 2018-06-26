package com.controller;

import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExportController
{

  @Autowired
  private EmployeeService employeeService;

  /**
   * Handle request to download an Excel document
   */
  @GetMapping("/download")
  public String download(Model model)
  {
    model.addAttribute("employees", employeeService.findAllEmployees());
    return "";
  }


}

