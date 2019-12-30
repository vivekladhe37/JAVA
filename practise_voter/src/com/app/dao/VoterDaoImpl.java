package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Voter;
@Repository
public class VoterDaoImpl implements IVoter {
    @Autowired 
	private SessionFactory  sf;
	public Voter authenticateVoter(String email,String password)
	{
		String jpql="select v from Voter v where v.email=:em and v.password=: pass";
		return sf.getCurrentSession().createQuery(jpql, Voter.class)
		.setParameter("em", email).setParameter("pass", password).getSingleResult();
	}
}
