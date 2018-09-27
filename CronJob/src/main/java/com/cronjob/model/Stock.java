package com.cronjob.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/09/27 11:08 AM
 * $Log: Stock.java
 */
public class Stock {

  private String stock_quote;

  private BigDecimal previous_close_price;

  private BigDecimal open_price;

  private BigDecimal price;

  private Timestamp creation_date;

  public String getStock_quote() {
    return stock_quote;
  }

  public void setStock_quote(String stock_quote) {
    this.stock_quote = stock_quote;
  }

  public BigDecimal getPrevious_close_price() {
    return previous_close_price;
  }

  public void setPrevious_close_price(BigDecimal previous_close_price) {
    this.previous_close_price = previous_close_price;
  }

  public BigDecimal getOpen_price() {
    return open_price;
  }

  public void setOpen_price(BigDecimal open_price) {
    this.open_price = open_price;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Timestamp getCreation_date() {
    return creation_date;
  }

  public void setCreation_date(Timestamp creation_date) {
    this.creation_date = creation_date;
  }
}
