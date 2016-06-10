package com.to.dao;

import com.to.entities.DeptFlightDetails;

public interface IDeptFlightDao {

	void persist(DeptFlightDetails deptFlt);

	DeptFlightDetails findByTripId(Long tripId);

}
