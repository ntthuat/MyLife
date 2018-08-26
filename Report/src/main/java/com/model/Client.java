package com.model;

import java.sql.Date;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/08/25 3:11 PM
 * $Log: Client.java
 */
public class Client {
  private String fullName;

  private String firstName;

  private String lastName;

  private Date birthDay;

  private String numberPhone;

  private String address;

  private String job;

  private Date createdDate;

  private String note;

  public Client(String fullName, String firstName, String lastName, Date birthDay, String numberPhone, String address, String job, Date createdDate, String note) {
    this.fullName = fullName;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDay = birthDay;
    this.numberPhone = numberPhone;
    this.address = address;
    this.job = job;
    this.createdDate = createdDate;
    this.note = note;
  }

  public Client() {
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(Date birthDay) {
    this.birthDay = birthDay;
  }

  public String getNumberPhone() {
    return numberPhone;
  }

  public void setNumberPhone(String numberPhone) {
    this.numberPhone = numberPhone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }
}
