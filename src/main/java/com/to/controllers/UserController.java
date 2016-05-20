package com.to.controllers;

import org.hibernate.internal.util.StringHelper;
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
		if (reqUser != null && StringHelper.isNotEmpty(reqUser.getEmailId())) {
			User existing = user.find(reqUser.getEmailId());
			if (existing == null) {
				user.persist(reqUser);
				return reqUser;
			}
			return existing;
		}
		// TODO: error out
		return null;
    }
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return user.find(id);
    }

}
