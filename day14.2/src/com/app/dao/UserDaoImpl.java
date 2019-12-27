package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Vendor;
import org.hibernate.*;

@Repository
//to tell spring --JPA based DAO layer
//triggers exc translation 
//mechanism(translates from db exc -->spring un chked excs)
public class UserDaoImpl implements IUserDao {
//dependency 
	@Autowired // byType
	private SessionFactory sf;

	@Override
	public Vendor authenticateUser(String email, String pass) {
		String jpql = "select v from Vendor v where v.email=:em and v.password=:pa";
		return sf.getCurrentSession().
				createQuery(jpql, Vendor.class).
				setParameter("em", email).
				setParameter("pa", pass)
				.getSingleResult();
	}

}
