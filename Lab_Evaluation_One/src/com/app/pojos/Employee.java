package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;
import org.hibernate.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employees")
public class Employee {

	private Integer id;
	private String empName, email;
	private double salary;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;

	private Department department;

	public Employee() {
		System.out.println("In Default Constructor of employee!!");
	}

	public Employee(String empName, String email, double salary, LocalDate dateOfBirth) {
		super();
		this.empName = empName;
		this.email = email;
		this.salary = salary;
		this.dateOfBirth = dateOfBirth;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "emp_name", length = 40)
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Column(length = 40,unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Column(name = "Date_of_birth")
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@ManyToOne
	@JoinColumn(name = "dept_id")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", email=" + email + ", salary=" + salary
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}

}
