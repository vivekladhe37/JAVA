package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Course;
@Repository
public class CourseDaoImpl implements ICourseDao {
    @Autowired
	SessionFactory sf;
	@Override
	public List<Course> getAllCourse() {
		String jpql="select c from Course c ";
		return sf.getCurrentSession().createQuery(jpql,Course.class).getResultList();
		
	}

}
