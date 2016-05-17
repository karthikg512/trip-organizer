package com.to.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.to.dao.IUserDao;
import com.to.dao.UserDao;
import com.to.entities.User;

@RestController
public class UserController {
	
	private IUserDao user = new UserDao();
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
    public User saveUser(@RequestBody User reqUser) {
		System.out.println("user request: " + reqUser);
        user.persist(reqUser);
		return reqUser;
    }

}
