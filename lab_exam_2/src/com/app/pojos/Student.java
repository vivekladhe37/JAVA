package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="students")
public class Student {
	private Integer id;			
	private String name, address;
	private LocalDate dob;
	private double cgpa;
	private Course course;
	public Student(String name, String address, LocalDate dob, double cgpa) {
		super();
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.cgpa = cgpa;
	}
	public Student() {
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getDob() {
		return dob;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	@ManyToOne
	@JoinColumn(name="course_id")
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", dob=" + dob + ", cgpa=" + cgpa
				+ "]";
	}
	
	

}
