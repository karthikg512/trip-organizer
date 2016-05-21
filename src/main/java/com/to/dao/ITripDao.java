package com.to.dao;

import com.to.entities.Trip;

public interface ITripDao {
	public void persist(Trip trip);
	public Trip find(Long id);

}
