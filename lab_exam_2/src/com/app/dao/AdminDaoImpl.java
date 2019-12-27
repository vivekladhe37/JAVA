package com.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Student;
@Repository
public class AdminDaoImpl implements IAdminDao {
	@Autowired
	private SessionFactory sf;
	
	public String registerStudent(Student s)
	{
	    Session hs=sf.getCurrentSession();
	    hs.save(s);
	    return "Student added successfully"+s.getId();
	    
	}

}
