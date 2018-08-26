package com.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/08/26 5:07 PM
 * $Log: ClientDaoTest.java
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientDaoTest {

  @Autowired
  private ClientDao clientDao;

  @Test
  public void testFindMaxIdClient() {
    String maxIdClient = clientDao.findMaxIdClient();
    System.out.println(maxIdClient);
    int idClentStr = Integer.parseInt(maxIdClient);
    idClentStr++;
    String newIdClient = Integer.toString(idClentStr);
    newIdClient = ("000" + newIdClient).substring(newIdClient.length());
    System.out.println(newIdClient);
  }
}
