package com.app.service;

import com.app.pojos.Vendor;

public interface IUserService {
	Vendor authenticateUser(String email, String pass);

}
