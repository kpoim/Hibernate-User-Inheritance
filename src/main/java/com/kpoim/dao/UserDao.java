package com.kpoim.dao;

import com.kpoim.entity.User;

public interface UserDao {

  User findByUsername(String username);

}
