package com.project.convention.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.convention.model.User;
import com.project.convention.repository.IUserDao;



@Service
public class UserService implements IUserService {

	
	@Autowired
	IUserDao userDao;
	
	@Override
	public boolean verifyUser(User user) {
		// TODO Auto-generated method stub		
		User usr = userDao.findUserByUsernameAndPassword(user.geUsername(), user.getPassword());
		if(usr != null)
			return true;
		return false;
	}


	
}
