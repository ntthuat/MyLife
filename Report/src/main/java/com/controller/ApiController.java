package com.controller;

import com.model.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by: tnthien
 * $Revision: 1.0 $ $Date: 2018/06/26 11:13:06 $
 * $Log: ApiController.java,v $
 */
@RestController
public class ApiController {

  @Autowired
  private EmployeeService employeeService;

  /**
   * Handle request to the default page
   */
  @GetMapping("/")
  public List<Employee> viewHome() {
    return employeeService.findAllEmployees();
  }


}
