package com.kpoim.service;

import com.kpoim.entity.Role;
import java.util.List;

public interface RoleService {

  public List<Role> getRoles();

  public Role findById(String source);

}
