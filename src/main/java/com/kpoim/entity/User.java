package com.kpoim.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;


@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  private String username;
  
  private String password;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinTable(name = "user_role",
	  joinColumns = @JoinColumn(name = "uid"),
	  inverseJoinColumns = @JoinColumn(name = "rid")
	  )
  List<Role> roles;

  public User() {
  }

  public User(String username, String password, List<Role> roles) {
	this.username = username;
	this.password = password;
	this.roles = roles;
  }

  public User(Integer id, String username, String password, List<Role> roles) {
	this.id = id;
	this.username = username;
	this.password = password;
	this.roles = roles;
  }

  public Integer getId() {
	return id;
  }

  public void setId(Integer id) {
	this.id = id;
  }

  public String getUsername() {
	return username;
  }

  public void setUsername(String username) {
	this.username = username;
  }

  public String getPassword() {
	return password;
  }

  public void setPassword(String password) {
	this.password = password;
  }

  public List<Role> getRoles() {
	return roles;
  }

  public void setRoles(List<Role> roles) {
	this.roles = roles;
  }

  @Override
  public int hashCode() {
	int hash = 3;
	hash = 29 * hash + Objects.hashCode(this.id);
	hash = 29 * hash + Objects.hashCode(this.username);
	hash = 29 * hash + Objects.hashCode(this.password);
	hash = 29 * hash + Objects.hashCode(this.roles);
	return hash;
  }

  @Override
  public boolean equals(Object obj) {
	if (this == obj) {
	  return true;
	}
	if (obj == null) {
	  return false;
	}
	if (getClass() != obj.getClass()) {
	  return false;
	}
	final User other = (User) obj;
	if (!Objects.equals(this.username, other.username)) {
	  return false;
	}
	if (!Objects.equals(this.password, other.password)) {
	  return false;
	}
	if (!Objects.equals(this.id, other.id)) {
	  return false;
	}
	if (!Objects.equals(this.roles, other.roles)) {
	  return false;
	}
	return true;
  }

  @Override
  public String toString() {
	return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", roles=" + roles + '}';
  }

}
