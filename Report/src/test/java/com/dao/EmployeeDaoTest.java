package com.dao;

import com.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $ $Date: 2018/06/29 11:37:43 $
 * $Log: EmployeeDaoTest.java,v $
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeDaoTest
{
  @Autowired
  private EmployeeDao employeeDao;

  @Test
  public void findAllTest(){
    List<Employee> list = employeeDao.findAll();
    System.out.println(list.size());
  }
}
