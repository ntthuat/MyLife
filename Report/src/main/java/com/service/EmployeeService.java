package com.service;

import com.dao.EmployeeDao;
import com.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $ $Date: 2018/06/26 10:58:17 $
 * $Log: EmployeeService.java,v $
 */
@Service
public class EmployeeService {

  @Autowired
  private EmployeeDao employeeDao;

  public List<Employee> findAllEmployees() {
    return employeeDao.findAll();
  }

  public Employee findEmployeeById(String id) {
    return employeeDao.findById(id);
  }

  public int insertEmployee() {
    //TODO
    return 0;
  }

  public int updateEmployee() {
    //TODO
    return 0;
  }

  public int deleteEmployee() {
    //TODO
    return 0;
  }

  @PostConstruct
  public void initIt() throws Exception {
    System.out.println("Into EmployeeService.initIt()...");
  }

  @PreDestroy
  public void cleanUp() throws Exception {
    System.out.println("Into EmployeeService.cleanUp()...");
  }
}
