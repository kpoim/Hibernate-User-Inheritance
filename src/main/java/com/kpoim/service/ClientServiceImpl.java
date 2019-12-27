package com.kpoim.service;

import com.kpoim.dao.ClientDao;
import com.kpoim.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
  
  @Autowired
  RoleService roleService;

  @Autowired
  ClientDao dao;
  
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;
  
  @Override
  public Client create(Client c) {
	c.setRole(roleService.findById("1"));
	c.setPassword(passwordEncoder.encode(c.getPassword()));
	return dao.create(c);
  }

}
