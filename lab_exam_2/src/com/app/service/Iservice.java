package com.app.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.app.pojos.Course;
import com.app.pojos.Student;

public interface Iservice {
	List<Course> getAllCourse();
	public String registerStudents(Student s,HttpSession hs);
	
}
