package com.model;

import java.sql.Date;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $ $Date: 2018/08/26 10:51:24 $
 * $Log: Order.java,v $
 */
public class Order {

  private String idOrder;

  private String idClient;

  private Date createdDate;

  private Date requiredDate;

  private Date shippedDate;

  private String status;

  private String note;

  public Order(String idOrder, String idClient, Date createdDate, Date requiredDate, Date shippedDate, String status, String note) {
    this.idOrder = idOrder;
    this.idClient = idClient;
    this.createdDate = createdDate;
    this.requiredDate = requiredDate;
    this.shippedDate = shippedDate;
    this.status = status;
    this.note = note;
  }

  public Order() {
  }

  public String getIdOrder() {
    return idOrder;
  }

  public void setIdOrder(String idOrder) {
    this.idOrder = idOrder;
  }

  public String getIdClient() {
    return idClient;
  }

  public void setIdClient(String idClient) {
    this.idClient = idClient;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public Date getRequiredDate() {
    return requiredDate;
  }

  public void setRequiredDate(Date requiredDate) {
    this.requiredDate = requiredDate;
  }

  public Date getShippedDate() {
    return shippedDate;
  }

  public void setShippedDate(Date shippedDate) {
    this.shippedDate = shippedDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }
}
