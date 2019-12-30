package com.app.service;
import com.app.pojos.Voter;
public interface IService {
	public Voter authenticateVoter( String email, String password);
}
