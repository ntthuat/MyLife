package com.dao;

import com.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/08/28 3:28 PM
 * $Log: OrderDetailDao.java
 */
@Repository
public class OrderDetailDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  class OrderDetailRowMapper implements RowMapper<OrderDetail> {
    @Override
    public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
      OrderDetail o = new OrderDetail();
      o.setIdOrder(rs.getString("IDORDER"));
      o.setIdProduct(rs.getString("IDPRODUCT"));
      o.setIdProduct(rs.getString("NAMEPRODUCT"));
      o.setUnitPrice(rs.getBigDecimal("UNITPRICE"));
      o.setQuantity(rs.getInt("QUANTITY"));
      o.setDiscount(rs.getInt("DISCOUNT"));
      return o;
    }
  }

  public List<OrderDetail> findAllByIdOrder(String id) {
    return jdbcTemplate.query("select * from report.orderdetail where idorder = ?", new Object[]{id}, new OrderDetailRowMapper());
  }

  public String findMaxId() {
    return (String) jdbcTemplate.queryForObject("select idproduct from report.orderdetail order by idproduct desc limit 1", String.class);
  }

  public int save(OrderDetail orderDetail) {
    return jdbcTemplate.update("insert into report.orderdetail values(?, ?, ?, ?, ?, ?)",
        new Object[]{orderDetail.getIdOrder(), orderDetail.getIdProduct(), orderDetail.getNameProduct() , orderDetail.getUnitPrice(), orderDetail.getQuantity(), orderDetail.getDiscount()});
  }
}
