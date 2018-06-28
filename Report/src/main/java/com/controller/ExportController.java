package com.controller;

import com.service.EmployeeService;
import com.view.MyExcelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ExportController {

  @Autowired
  private EmployeeService employeeService;

  /**
   * Handle request to download an Excel document
   */
  @GetMapping("/download")
  /*@RequestMapping(value="/download", produces={"application/xml", "application/json"})*/
  public String download(Model model) {
    model.addAttribute("employees", employeeService.findAllEmployees());
    return "download";
  }

  @RequestMapping(value="/download2", method= RequestMethod.GET)
  public ModelAndView getMyData(HttpServletRequest request, HttpServletResponse response) throws SQLException
  {
    Map<String, Object> model = new HashMap<String, Object>();
    //Sheet Name
    model.put("sheetname", "TestSheetName");
    //Headers List
    List<String> headers = new ArrayList<String>();
    headers.add("Column1");
    headers.add("Column2");
    headers.add("Column3");
    model.put("headers", headers);
    //Results Table (List<Object[]>)
    List<List<String>> results = new ArrayList<List<String>>();
    List<String> l1 = new ArrayList<String>();
    l1.add("A1");
    l1.add("B1");
    l1.add("C1");
    results.add(l1);
    List<String> l2 = new ArrayList<String>();
    l2.add("A2");
    l2.add("B2");
    l2.add("C2");
    results.add(l2);
    model.put("results",results);
    response.setContentType( "application/ms-excel" );
    response.setHeader( "Content-disposition", "attachment; filename=myfile.xls" );
    return new ModelAndView(new MyExcelView(), model);
  }
}

