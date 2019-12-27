package com.kpoim.service;

import com.kpoim.dao.AdminDao;
import com.kpoim.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
  
  @Autowired
  RoleService roleService;

  @Autowired
  AdminDao dao;
  
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;
  
  @Override
  public Admin create(Admin a) {
	a.setRole(roleService.findById("3"));
	a.setPassword(passwordEncoder.encode(a.getPassword()));
	return dao.create(a);
  }
  
}
