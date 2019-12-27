package com.kpoim.dao;

import com.kpoim.entity.Role;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends SuperDao implements RoleDao {

  @Override
  public List<Role> getRoles() {
	Query q = getSession().createQuery("from Role");
	return q.getResultList();
  }

  @Override
  public Role findById(Integer source) {
	return getSession().byId(Role.class).load(source);
//	Query q = getSession().createQuery("SELECT r FROM Role r WHERE r.rid = :id");
//	q.setParameter("id", source);
//	Role role = null;
//	try {
//	  role = (Role) q.getSingleResult();
//	} catch (NoResultException e) {
//	}
//	return role;
  }

}
