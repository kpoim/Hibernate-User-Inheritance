package com.kpoim.dao;

import com.kpoim.entity.Role;
import java.util.List;

public interface RoleDao {

  public List<Role> getRoles();

  public Role findById(Integer source);

}
