package com.kpoim.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "employee")
public class Employee extends User implements Serializable {

  @Column(name = "empfname")
  private String firstName;
  
  @Column(name = "emplname")
  private String lastName;
  
  @Column(name = "empphone")
  private String phone;

  public Employee() {
  }

  public Employee(String firstName, String lastName, String phone, String username, String password, List<Role> roles) {
	super(username, password, roles);
	this.firstName = firstName;
	this.lastName = lastName;
	this.phone = phone;
  }

  public Employee(String firstName, String lastName, String phone, Integer id, String username, String password, List<Role> roles) {
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
	int hash = 3;
	hash = 17 * hash + Objects.hashCode(this.firstName);
	hash = 17 * hash + Objects.hashCode(this.lastName);
	hash = 17 * hash + Objects.hashCode(this.phone);
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
	final Employee other = (Employee) obj;
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
	return super.toString() + "\nEmployee{" + "firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + '}';
  }

}
