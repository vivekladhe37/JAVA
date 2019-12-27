package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import org.hibernate.*;

@Entity
@Table(name = "depts")
public class Department {

	private Integer id;
	private String location, deptName;
	private int strength;

	private List<Employee> emps = new ArrayList<Employee>();

	public Department() {
		System.out.println("In default Constructor of Department");
	}

	public Department(String location, String deptName, int strength) {
		super();
		this.location = location;
		this.deptName = deptName;
		this.strength = strength;
	}
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 40)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
	@Column(name = "dept_name",length = 40)
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(length = 40)
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", location=" + location + ", deptName=" + deptName + ", strength=" + strength
				+ "]";
	}
	
	public void addEmployee(Employee e)
	{
		emps.add(e);
		e.setDepartment(this);
	}
	
	

}
