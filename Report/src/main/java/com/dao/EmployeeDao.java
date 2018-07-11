package com.dao;

import com.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by: tnthien
 * $Revision: 1.0 $ $Date: 2018/06/26 16:02:08 $
 * $Log: EmployeeDao.java,v $
 */
@Repository
public class EmployeeDao {

  @Autowired
  JdbcTemplate jdbcTemplate;

  class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
      Employee e = new Employee();
      e.setFirstName(rs.getString("FIRSTNAME"));
      e.setLastName(rs.getString("LASTNAME"));
      e.setBirthDay(rs.getString("BIRTHDAY"));
      e.setJobTitle(rs.getString("JOBTITLE"));
      e.setCompany(rs.getString("COMPANY"));
      e.setCity(rs.getString("CITY"));
      e.setCountry(rs.getString("COUNTRY"));
      e.setAddress(rs.getString("ADDRESS"));
      e.setPhoneNumber(rs.getString("PHONENUMBER"));
      return e;
    }
  }

  public List<Employee> findAll() {
    return jdbcTemplate.query("select * from report.employee", new EmployeeRowMapper());
  }

  public Employee findById(String id) {
    return jdbcTemplate.queryForObject("select * from report.employee where idemployee=?", new Object[]{id},
        new BeanPropertyRowMapper<Employee>(Employee.class));
  }

  public int deleteById(long id) {
    return jdbcTemplate.update("delete from student where id=?", new Object[]{id});
  }

  public int insert(Employee student) {
    /*return jdbcTemplate.update("insert into student (id, name, passport_number) " + "values(?,  ?, ?)",
        new Object[] { student.getId(), student.getName(), student.getPassportNumber() });*/

    return 0;
  }

  public int update(Employee student) {
    /*return jdbcTemplate.update("update student " + " set name = ?, passport_number = ? " + " where id = ?",
        new Object[] { student.getName(), student.getPassportNumber(), student.getId() });*/

    return 0;
  }
}
