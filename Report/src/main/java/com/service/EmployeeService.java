package com.service;

import com.dao.EmployeeDao;
import com.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by: tnthien
 * $Revision: 1.0 $ $Date: 2018/06/26 10:58:17 $
 * $Log: EmployeeService.java,v $
 */
@Service
public class EmployeeService
{

  @Autowired
  EmployeeDao employeeDao;

  public List<Employee> findAllEmployees()
  {
    return employeeDao.fakeEmployees();
  }
}
