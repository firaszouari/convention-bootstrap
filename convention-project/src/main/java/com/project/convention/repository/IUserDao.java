package com.project.convention.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.project.convention.model.User;


public interface IUserDao extends CrudRepository<User, Integer> {
	
	@Query("select u from User u where u.username = ?1 and u.password = ?2 ")
	User findUserByUsernameAndPassword(String username, String password);
}
