package com.kpoim.dao;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

public class SuperDao {
  
  @Autowired
  private EntityManager em;
  
  protected Session getSession(){
	return em.unwrap(Session.class);
  }
  
  
}
