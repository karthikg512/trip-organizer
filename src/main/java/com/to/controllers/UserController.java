package com.to.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.to.dao.IUserDao;
import com.to.entities.User;

@RestController
public class UserController {
	
	@Autowired
	private IUserDao user;
	
	@RequestMapping(value="/user", method=RequestMethod.POST)
    public User saveUser(@RequestBody User reqUser) {
        user.persist(reqUser);
		return reqUser;
    }
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
		System.out.println("user id: " + id);
        return user.find(id);
    }

}
