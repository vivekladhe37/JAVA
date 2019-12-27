package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="courses")
public class Course {
	private Integer id;
	private  String courseName;
	private List<Student> studs =new ArrayList<Student>();
	public Course( String courseName) {
		super();
	
		this.courseName = courseName;
	}
	public Course() {
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
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@OneToMany(mappedBy ="course",cascade = CascadeType.ALL)
	public List<Student> getStuds() {
		return studs;
	}
	public void setStuds(List<Student> studs) {
		this.studs = studs;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + "]";
	}
	
	public void addStudent(Student d)
	{
		studs.add(d);
		d.setCourse(this);
	}

}
