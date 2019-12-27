package com.kpoim.dao;

import com.kpoim.entity.Client;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDaoImpl extends SuperDao implements ClientDao {

  @Override
  public Client create(Client c) {
	getSession().save(c);
	return c;
  }
  
}
