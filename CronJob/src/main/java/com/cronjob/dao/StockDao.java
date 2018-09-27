package com.cronjob.dao;

import com.cronjob.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/09/27 11:29 AM
 * $Log: StockDao.java
 */
@Repository
public class StockDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  class StockRowMapper implements RowMapper<Stock> {
    @Override
    public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
      Stock s = new Stock();
      s.setStock_quote(rs.getString("stock_quote"));
      s.setPrevious_close_price(rs.getBigDecimal("previous_close_price"));
      s.setOpen_price(rs.getBigDecimal("open_price"));
      s.setPrice(rs.getBigDecimal("price"));
      s.setCreation_date(rs.getTimestamp("creation_date"));
      return s;
    }
  }

  public List<Stock> findAllNasdaq() {
    return jdbcTemplate.query("select * from stock.nasdaq", new StockRowMapper());
  }

}
