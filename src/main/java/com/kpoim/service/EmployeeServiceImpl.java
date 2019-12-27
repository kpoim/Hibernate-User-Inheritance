package com.kpoim.service;

import com.kpoim.dao.EmployeeDao;
import com.kpoim.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  EmployeeDao dao;
  
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;
  
  @Override
  public Employee create(Employee e) {
	e.setPassword(passwordEncoder.encode(e.getPassword()));
	return dao.create(e);
  }
  
}
