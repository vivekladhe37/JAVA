package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.Vendor;
@Service
@Transactional
public class UserServiceImpl implements IUserService {

	//dependency
	@Autowired //by type
	private IUserDao dao;
	@Override
	public Vendor authenticateUser(String email, String pass) {
		// TODO Auto-generated method stub
		return dao.authenticateUser(email, pass);
	}

}
