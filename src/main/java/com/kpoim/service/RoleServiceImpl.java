package com.kpoim.service;

import com.kpoim.dao.RoleDao;
import com.kpoim.entity.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {

  @Autowired
  RoleDao dao;
  
  @Override
  public List<Role> getRoles() {
	return dao.getRoles();
  }

  @Override
  public Role findById(String source) {
	Integer id = Integer.parseInt(source);
	return dao.findById(id);
  }
  
  
  
}
