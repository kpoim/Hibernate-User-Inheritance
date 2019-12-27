package com.kpoim.config;

import com.kpoim.service.UserService;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@Configuration
@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserService userService;
  
//  @Autowired
//  private DataSource datasource;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	//UserBuilder userBuilder = User.builder();
//	auth.jdbcAuthentication().dataSource(datasource);
	auth.authenticationProvider(authenticationProvider());
//        auth.inMemoryAuthentication()
//                .withUser(userBuilder.username("admin").password("{noop}1234").roles("ADMIN", "USER"))
//                .withUser(userBuilder.username("user").password("{noop}1234").roles("USER"))
//                .withUser(userBuilder.username("nick").password("{noop}1234").roles("GUEST"));

  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()//Restrict access based on HttServletRequest
		//.anyRequest().authenticated()//Any request to the app must be authenticated(logged in)
		.antMatchers("/").hasAnyRole("USER", "ADMIN", "EMPLOYEE")
		.antMatchers("/newClient").hasAnyRole("USER", "ADMIN")
		.antMatchers("/newAdmin/**").hasRole("ADMIN")
		.antMatchers("/newEmployee/**").hasRole("ADMIN")
//		.antMatchers("/*/create/**","/*/update/**","/*/delete/**").hasRole("ADMIN")
		.and()
		.formLogin()//We are customizing the form login process
//		.loginPage("/loginPage")//Show my form at the request mapping
//		.loginProcessingUrl("/authenticate")//Login form will POST data to this URL for processing username and password
		.permitAll()//Allow everyone to see Login page. Don't have to be logged in.
		.and().logout().permitAll()
//		.and().exceptionHandling().accessDeniedPage("/access-denied")
		;
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider(){
	DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
	auth.setUserDetailsService(userService);
	auth.setPasswordEncoder(passwordEncoder());
	return auth;
  }
  
  @Bean
  public BCryptPasswordEncoder passwordEncoder(){
	return new BCryptPasswordEncoder();
  }
  
}
