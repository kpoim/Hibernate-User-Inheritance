package com.kpoim.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin extends User implements Serializable {
  
  @Column(name = "adminfname")
  private String firstName;
  
  @Column(name = "adminlname")
  private String lastName;
  
  @Column(name = "adminphone")
  private String phone;

  public Admin() {
  }

  public Admin(String firstName, String lastName, String phone, String username, String password, List<Role> roles) {
	super(username, password, roles);
	this.firstName = firstName;
	this.lastName = lastName;
	this.phone = phone;
  }

  public Admin(String firstName, String lastName, String phone, Integer id, String username, String password, List<Role> roles) {
	super(id, username, password, roles);
	this.firstName = firstName;
	this.lastName = lastName;
	this.phone = phone;
  }
  
  public String getFirstName() {
	return firstName;
  }

  public void setFirstName(String firstName) {
	this.firstName = firstName;
  }

  public String getLastName() {
	return lastName;
  }

  public void setLastName(String lastName) {
	this.lastName = lastName;
  }

  public String getPhone() {
	return phone;
  }

  public void setPhone(String phone) {
	this.phone = phone;
  }

  @Override
  public int hashCode() {
	int hash = 5;
	hash = 43 * hash + Objects.hashCode(this.firstName);
	hash = 43 * hash + Objects.hashCode(this.lastName);
	hash = 43 * hash + Objects.hashCode(this.phone);
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
	final Admin other = (Admin) obj;
	if (!Objects.equals(this.firstName, other.firstName)) {
	  return false;
	}
	if (!Objects.equals(this.lastName, other.lastName)) {
	  return false;
	}
	if (!Objects.equals(this.phone, other.phone)) {
	  return false;
	}
	return true;
  }

  @Override
  public String toString() {
	return super.toString() + "\nAdmin{" + "firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + '}';
  }

}
