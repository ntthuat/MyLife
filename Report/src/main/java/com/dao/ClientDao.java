package com.dao;

import com.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/08/25 3:17 PM
 * $Log: ClientDao.java
 */
@Repository
public class ClientDao {

  private final static String COUNTRY_VIETNAM = "Việt Nam";

  @Autowired
  JdbcTemplate jdbcTemplate;

  class ClientRowMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
      Client c = new Client();
      c.setFirstName(rs.getString("FIRSTNAME"));
      c.setLastName(rs.getString("LASTNAME"));
      c.setFullName(c.getLastName() + " " + c.getFirstName());
      c.setBirthDay(rs.getDate("BIRTHDAY"));
      c.setNumberPhone(rs.getString("NUMBERPHONE"));
      c.setAddress(rs.getString("ADDRESS"));
      c.setJob(rs.getString("JOB"));
      c.setCreatedDate(rs.getDate("CREATEDDATE"));
      c.setNote(rs.getString("NOTE"));
      return c;
    }
  }

  public List<Client> findAll() {
    return jdbcTemplate.query("select * from report.client", new ClientDao.ClientRowMapper());
  }

  public int save(Client client) {
    final String maxIdClient = findMaxIdClient();
    int idClentStr = Integer.parseInt(maxIdClient);
    idClentStr++;
    String newIdClient = Integer.toString(idClentStr);
    newIdClient = ("000" + newIdClient).substring(newIdClient.length());
    return jdbcTemplate.update("insert into report.client values(?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?)",
        new Object[]{newIdClient, client.getFirstName(), client.getLastName(), client.getBirthDay(), client.getNumberPhone(), client.getAddress(), client.getJob(), COUNTRY_VIETNAM, client.getNote()});
  }

  public String findMaxIdClient() {
    return (String) jdbcTemplate.queryForObject("select idclient from report.client order by idclient desc limit 1", String.class);
  }
}
