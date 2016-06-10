package com.to.entities;

import java.util.List;

public class TripDetails {

	private List<User> users;
	private CarRentalDetails carRental;
	private Activities activities;
	private DeptFlightDetails deptFlightDetails;
	private ArrFlightDetails arrFlightDetails;
	private AccommodationDetails accommDetails;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public CarRentalDetails getCarRental() {
		return carRental;
	}

	public void setCarRental(CarRentalDetails carRental) {
		this.carRental = carRental;
	}

	public Activities getActivities() {
		return activities;
	}

	public void setActivities(Activities activities) {
		this.activities = activities;
	}

	public DeptFlightDetails getDeptFlightDetails() {
		return deptFlightDetails;
	}

	public void setDeptFlightDetails(DeptFlightDetails deptFlightDetails) {
		this.deptFlightDetails = deptFlightDetails;
	}

	public ArrFlightDetails getArrFlightDetails() {
		return arrFlightDetails;
	}

	public void setArrFlightDetails(ArrFlightDetails arrFlightDetails) {
		this.arrFlightDetails = arrFlightDetails;
	}

	public AccommodationDetails getAccommDetails() {
		return accommDetails;
	}

	public void setAccommDetails(AccommodationDetails accommDetails) {
		this.accommDetails = accommDetails;
	}

	@Override
	public String toString() {
		return "TripDetails [users=" + users + ", carRental=" + carRental + ", activities=" + activities
				+ ", deptFlightDetails=" + deptFlightDetails + ", arrFlightDetails=" + arrFlightDetails
				+ ", accommDetails=" + accommDetails + "]";
	}

}
