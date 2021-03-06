package nl.harmster.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Employee {

 @Id
 @GeneratedValue
 private int id;

 @Column(name = "first_name")
 private String firstName;

 @Column(name = "last_name")
 private String lastName;

 private String email;
 private String phone;

 @ManyToOne(cascade = {CascadeType.ALL})
 @PrimaryKeyJoinColumn
 private UserAccount userAccount;
 
 
 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
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

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public String getPhone() {
  return phone;
 }

 public void setPhone(String phone) {
  this.phone = phone;
 }

public UserAccount getUserAccount() {
	return userAccount;
}

public void setUserAccount(UserAccount userAccount) {
	this.userAccount = userAccount;
}

 
}