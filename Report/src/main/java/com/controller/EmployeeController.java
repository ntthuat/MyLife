package com.controller;

import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by: tnthien
 * $Revision: 1.0 $ $Date: 2018/06/26 16:27:26 $
 * $Log: EmployeeController.java,v $
 */
@Controller
public class EmployeeController
{
  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/all-employees")
  public String allEmployees(Model model){
    List employees = employeeService.findAllEmployees();
    model.addAttribute("employees", employees);
    return "all-employees";
  }
}
