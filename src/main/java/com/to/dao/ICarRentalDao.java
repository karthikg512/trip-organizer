package com.to.dao;

import com.to.entities.CarRentalDetails;

public interface ICarRentalDao {

	void persist(CarRentalDetails car);

	CarRentalDetails findByTripId(Long tripId);

}
