package com.kpoim.config;

import com.kpoim.entity.Role;
import com.kpoim.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class StringToRoleConverter implements Converter<String, Role>{

  @Autowired
  RoleService service;
  
  @Override
  public Role convert(String source) {
	return service.findById(source);
  }
  
}
