package com.dao;

import com.model.Client;
import com.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $ $Date: 2018/08/26 16:02:08 $
 * $Log: OrderDao.java,v $
 */
@Repository
public class OrderDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
      Order o = new Order();
      o.setIdOrder(rs.getString("IDORDER"));
      o.setIdClient(rs.getString("IDCLIENT"));
      o.setCreatedDate(rs.getDate("CREATEDDATE"));
      o.setRequiredDate(rs.getDate("REQUIREDDATE"));
      o.setShippedDate(rs.getDate("SHIPPEDDATE"));
      o.setStatus(rs.getString("STATUS"));
      o.setNote(rs.getString("NOTE"));
      return o;
    }
  }

  public List<Order> findAll() {
    return jdbcTemplate.query("select * from report.orders", new OrderDao.OrderRowMapper());
  }

  public int save(Order order) {
    final String maxId = findMaxId();
    int newId_int = Integer.parseInt(maxId);
    newId_int++;
    String newId_String = Integer.toString(newId_int);
    newId_String = ("0000" + newId_String).substring(newId_String.length());
    return jdbcTemplate.update("insert into report.orders values(?, ?, SYSDATE, ?, NULL, ?, ?)",
        new Object[]{newId_String, order.getIdClient(), order.getRequiredDate(), "Đã Nhận", order.getNote()});
  }

  public String findMaxId() {
    return (String) jdbcTemplate.queryForObject("select idorder from report.orders order by idorder desc limit 1", String.class);
  }
}
