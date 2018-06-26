package com.model;

/**
 * Created by: tnthien
 * $Revision: 1.0 $ $Date: 2018/06/26 10:51:24 $
 * $Log: Employee.java,v $
 */
public class Employee
{
  private String firstName;

  private String lastName;

  private Integer age;

  private String jobTitle;

  private String company;

  private String address;

  private String city;

  private String country;

  private String phoneNumber;

  public Employee(String firstName, String lastName, Integer age, String jobTitle, String company, String address, String city, String country, String phoneNumber)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.jobTitle = jobTitle;
    this.company = company;
    this.address = address;
    this.city = city;
    this.country = country;
    this.phoneNumber = phoneNumber;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public Integer getAge()
  {
    return age;
  }

  public void setAge(Integer age)
  {
    this.age = age;
  }

  public String getJobTitle()
  {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle)
  {
    this.jobTitle = jobTitle;
  }

  public String getCompany()
  {
    return company;
  }

  public void setCompany(String company)
  {
    this.company = company;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public String getCity()
  {
    return city;
  }

  public void setCity(String city)
  {
    this.city = city;
  }

  public String getCountry()
  {
    return country;
  }

  public void setCountry(String country)
  {
    this.country = country;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }
}
