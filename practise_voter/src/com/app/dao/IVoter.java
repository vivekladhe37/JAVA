package com.app.dao;

import com.app.pojos.Voter;

public interface IVoter {
 Voter authenticateVoter(String email,String password);
}
