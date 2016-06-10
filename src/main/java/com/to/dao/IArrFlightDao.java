package com.to.dao;

import com.to.entities.ArrFlightDetails;

public interface IArrFlightDao {

	void persist(ArrFlightDetails arrFlt);

	ArrFlightDetails findByTripId(Long tripId);

}
