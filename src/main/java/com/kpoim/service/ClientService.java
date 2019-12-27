package com.kpoim.service;

import com.kpoim.entity.Client;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ClientService {//extends UserDetailsService {

  Client create(Client c);

//  Client findByUsernme(String username);
}
