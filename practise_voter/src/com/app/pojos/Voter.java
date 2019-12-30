package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name="voters")
public class Voter {
 public Integer id;
 public String email,password;
 public String status;
public Voter(Integer id, String email, String password, String status) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
	this.status = status;
}
public Voter() {
	super();
}
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "Voter [id=" + id + ", email=" + email + ", password=" + password + ", status=" + status + "]";
}
 
}
