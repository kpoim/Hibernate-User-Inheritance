package com.kpoim.config;

import com.kpoim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserService userService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.authenticationProvider(authenticationProvider());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()//Restrict access based on HttServletRequest
		.antMatchers("/").permitAll()//.hasAnyRole("CLIENT", "ADMIN", "EMPLOYEE")
		.antMatchers("/newClient").permitAll()
		.antMatchers("/newAdmin/**").hasRole("ADMIN")
		.antMatchers("/newEmployee/**").hasRole("ADMIN")
		.and().formLogin().permitAll()
		.and().logout().permitAll()
		;
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
	DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
	auth.setUserDetailsService(userService);
	auth.setPasswordEncoder(passwordEncoder());
	return auth;
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
  }

}
