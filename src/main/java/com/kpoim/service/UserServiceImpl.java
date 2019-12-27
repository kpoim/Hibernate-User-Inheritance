package com.kpoim.service;

import com.kpoim.dao.UserDao;
import com.kpoim.entity.Role;
import com.kpoim.entity.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
  
  @Autowired
  UserDao dao;

  @Override
  public User findByUsernme(String username) {
	return dao.findByUsername(username);
  }

  @Override
  public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
	User user = findByUsernme(string);
	if(user == null){
	  throw new UsernameNotFoundException("Invalid Username");
	}
	return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user.getRole()));
  }
  
  
  private Collection<? extends GrantedAuthority> getGrantedAuthorities(Role role){
	List<GrantedAuthority> authorities = new ArrayList<>();
	authorities.add(new SimpleGrantedAuthority(role.getRname()));
	return authorities;
  }
}
