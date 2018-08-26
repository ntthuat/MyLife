package com.service;

import com.dao.ClientDao;
import com.model.Client;
import com.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by: ntthuat
 * $Revision: 1.0 $Date: 2018/08/25 3:26 PM
 * $Log: ClientService.java
 */
@Service
public class ClientService {

  @Autowired
  private ClientDao clientDao;

  public List<Client> findAllClients() {
    return clientDao.findAll();
  }
}
