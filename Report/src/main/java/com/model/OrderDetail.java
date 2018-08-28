package com.model;

import java.math.BigDecimal;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/08/28 3:10 PM
 * $Log: OrderDetail.java
 */
public class OrderDetail {

  private String idOrder;

  private String idProduct;

  private String nameProduct;

  private BigDecimal unitPrice;

  private Integer quantity;

  private Integer discount;

  public OrderDetail(String idOrder, String idProduct, String nameProduct, BigDecimal unitPrice, Integer quantity, Integer discount) {
    this.idOrder = idOrder;
    this.idProduct = idProduct;
    this.nameProduct = nameProduct;
    this.unitPrice = unitPrice;
    this.quantity = quantity;
    this.discount = discount;
  }

  public OrderDetail() {
  }

  public String getIdOrder() {
    return idOrder;
  }

  public void setIdOrder(String idOrder) {
    this.idOrder = idOrder;
  }

  public String getIdProduct() {
    return idProduct;
  }

  public void setIdProduct(String idProduct) {
    this.idProduct = idProduct;
  }

  public BigDecimal getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(BigDecimal unitPrice) {
    this.unitPrice = unitPrice;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Integer getDiscount() {
    return discount;
  }

  public void setDiscount(Integer discount) {
    this.discount = discount;
  }

  public String getNameProduct() {
    return nameProduct;
  }

  public void setNameProduct(String nameProduct) {
    this.nameProduct = nameProduct;
  }
}
