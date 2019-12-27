package com.kpoim.dao;

import com.kpoim.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends SuperDao implements EmployeeDao {

  @Override
  public Employee create(Employee e) {
	getSession().save(e);
	return e;
  }
  
}
