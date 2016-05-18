package com.to.dao;

import com.to.entities.User;

public interface IUserDao {
	public void persist(User user);
	public User find(Long id);
}
