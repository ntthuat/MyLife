package com.controller;

import com.service.EmployeeService;
import com.view.ExcelView;
import com.view.TinhHoaView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $ $Date: 2018/06/26 16:27:26 $
 * $Log: EmployeeController.java,v $
 */
@Controller
public class EmployeeController {
  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/all-employees")
  public String allEmployees(Model model) {
    List employees = employeeService.findAllEmployees();
    model.addAttribute("employees", employees);
    model.addAttribute("content", "Testtt");
    return "all-employees";
  }

  @GetMapping("/all-employees/download")
  public ModelAndView allEmployeesDownload(Model model) {
    model.addAttribute("employees", employeeService.findAllEmployees());
    return new ModelAndView(new ExcelView());
  }

  @GetMapping("/all-employees/lich_lam_viec")
  public ModelAndView getLichLamViec(Map<String, Object> model) {
    // TODO: https://medium.com/@trevormydata/week-5-thymeleaf-with-spring-mvc-rapid-introduction-to-the-essentials-799f1fba8c07
    return new ModelAndView(new TinhHoaView());
  }

  @GetMapping("/employee/{id}")
  public String getEmployeeById(@PathVariable("id") String id, Model model) {
    model.addAttribute("employees", employeeService.findEmployeeById(id));
    return "all-employees";
  }
}
