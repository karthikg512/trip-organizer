package com.to.dao;

import com.to.entities.Activities;

public interface IActivitiesDao {

	void persist(Activities acct);

	Activities findByTripId(Long tripId);
}
