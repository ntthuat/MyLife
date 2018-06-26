package com.service;

import com.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by: tnthien
 * $Revision: 1.0 $ $Date: 2018/06/26 10:58:17 $
 * $Log: EmployeeService.java,v $
 */
@Service
public class EmployeeService
{
  public List<Employee> findAllEmployees() {
    Employee e1 = new Employee("A", "B", 21, "C", "D", "E", "F", "G", "H");
    Employee e2 = new Employee("A2", "B2", 22, "C2", "D2", "E2", "F2", "G2", "H2");
    List list = new LinkedList();
    list.add(e1);
    list.add(e2);
    return  list;
  }
}
