package com.kpoim.service;

import com.kpoim.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

  public User findByUsernme(String username);

  
}
