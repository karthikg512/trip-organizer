package com.to.dao;

import com.to.entities.Trip;
import com.to.entities.TripDetails;

public interface ITripDao {
	public void persist(Trip trip);
	public Trip find(Long id);
	public TripDetails getDetails(Long id);

}
