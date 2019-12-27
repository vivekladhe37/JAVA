package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="vendors")
public class Vendor {
	private Integer id;
	private String name="some name",email="some email",password,city,cellNo,role;
	private double regAmount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate regDate;
	public Vendor() {
		System.out.println("in vendor constr");
	}
	public Vendor(String name, String email, String password, String city, String cellNo, String role, double regAmount,
			LocalDate regDate) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.city = city;
		this.cellNo = cellNo;
		this.role = role;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(name="cell_no")
	public String getCellNo() {
		return cellNo;
	}
	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Column(name="reg_amount")
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	@Column(name="reg_date")
	public LocalDate getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Vendor [id=" + id + ", name=" + name + ", email=" + email + ", city=" + city + ", cellNo=" + cellNo
				+ ", role=" + role + ", regAmount=" + regAmount + ", regDate=" + regDate + "]";
	}
	

}
