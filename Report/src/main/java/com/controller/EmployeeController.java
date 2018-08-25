package com.controller;

import com.service.EmployeeService;
import com.view.ExcelView;
import com.view.TinhHoaView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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
    model.addAttribute("greeting", new Greeting());
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

  @GetMapping("/greeting")
  public String greetingForm(Model model) {
    model.addAttribute("greeting", new Greeting());
    return "greeting";
  }

  @PostMapping("/greeting")
  public String greetingSubmit(@ModelAttribute Greeting greeting) {
    return "result";
  }

  // only for test
  @RequestMapping(method = GET, value = "/fooBar")
  public ResponseEntity<String> fooBar() {
    String json = "jsonResponse";
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.setContentType(MediaType.APPLICATION_JSON);
    return new ResponseEntity<String>(json, responseHeaders, HttpStatus.CREATED);
  }

  //only for test
  /*@RequestMapping(value = "/foo", method = GET)
  public final String foo(HttpServletRequest request, BindingResult bindResult, ModelMap model) {
    model.addAttribute("abc", 123);
    model.addAttribute("employees", employeeService.findEmployeeById("001"));
    return "all-employees";
  }*/
}
