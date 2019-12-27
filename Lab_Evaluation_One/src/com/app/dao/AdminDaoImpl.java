package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Employee;
import org.hibernate.*;

@Repository
public class AdminDaoImpl implements IAdminDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public String registerEmployee(Employee e) {

		System.out.println("In Register Employee Dao");
		Session hs = sf.getCurrentSession();
		hs.save(e);

		return "Employee Registered Successfully with id" + e.getId() + "!!";
	}

}
