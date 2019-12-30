package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.VoterDaoImpl;
import com.app.pojos.Voter;
@Service
@Transactional
public class ServiceImpl implements IService {

	@Autowired
	private VoterDaoImpl voterdao;
	public Voter authenticateVoter( String email, String password)
	{
		return voterdao.authenticateVoter(email, password);
		
	}
  
}
