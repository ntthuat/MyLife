package com.dao;

import com.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by: tnthien
 * $Revision: 1.0 $ $Date: 2018/06/26 16:02:08 $
 * $Log: EmployeeDao.java,v $
 */
@Repository
public class EmployeeDao
{
  public List<Employee> fakeEmployees(){
    Employee e1 = new Employee();
    e1.setFirstName("Phuong");
    e1.setLastName("Doan Thi Lam");
    e1.setBirthDay("1997");
    e1.setAddress("Cam Lam");
    e1.setCity("Khanh Hoa");
    e1.setCompany("Tinh Hoa");
    e1.setCountry("Viet Nam");
    e1.setJobTitle("Supervisor");
    e1.setPhoneNumber("0164 918 5xxx");

    Employee e2 = new Employee();
    e2.setFirstName("Thuat");
    e2.setLastName("Nguyen Thien");
    e2.setBirthDay("1992");
    e2.setAddress("Ba Tri");
    e2.setCity("Ben Tre");
    e2.setCompany("Codix");
    e2.setCountry("Viet Nam");
    e2.setJobTitle("Engineer");
    e2.setPhoneNumber("0124 7679 xxx");

    List list = new LinkedList();
    list.add(e1);
    list.add(e2);

    return list;
  }
}
