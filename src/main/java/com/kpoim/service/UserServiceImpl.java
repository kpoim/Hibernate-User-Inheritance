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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
  
  @Autowired
  UserDao dao;
  
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Override
  public User findByUsernme(String username) {
	return dao.findByUsername(username);
  }

  @Override
  public void save(User user) {
	user.setPassword(passwordEncoder.encode(user.getPassword()));
	dao.save(user);
  }

  @Override
  public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
	User user = findByUsernme(string);
	if(user == null){
	  throw new UsernameNotFoundException("Invalid Username");
	}
	return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user.getRoles()));
  }
  
  
  private Collection<? extends GrantedAuthority> getGrantedAuthorities(List<Role> roles){
	List<GrantedAuthority> authorities = new ArrayList<>();
	for(Role r:roles){
	  SimpleGrantedAuthority authority = new SimpleGrantedAuthority(r.getRname());
	  authorities.add(authority);
	}
	return authorities;
  }
}
