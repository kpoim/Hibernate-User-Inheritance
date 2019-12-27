package com.kpoim.dao;

import com.kpoim.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDaoImpl extends SuperDao implements AdminDao {

  @Override
  public Admin create(Admin a) {
	getSession().save(a);
	return a;
  }
  
}
