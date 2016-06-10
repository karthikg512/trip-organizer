package com.to.dao;

import com.to.entities.AccommodationDetails;

public interface IAccommodationDao {

	void persist(AccommodationDetails reqAccm);

	AccommodationDetails findByTripId(Long tripId);

}
