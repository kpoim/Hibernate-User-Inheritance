package com.kpoim.dao;

import com.kpoim.entity.User;

public interface UserDao {

  void save(User user);

  User findByUsername(String username);

}
