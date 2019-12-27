package com.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Department;
import org.hibernate.*;

@Repository
public class DepartmentDaoimpl implements IDepartmentDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public List<Department> getDepartments() {
		
		String jpql="select d from Department d";
		return sf.getCurrentSession().createQuery(jpql, Department.class).
				getResultList();
	}

	
	
}
