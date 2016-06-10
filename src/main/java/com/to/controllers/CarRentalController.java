package com.to.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.to.dao.ICarRentalDao;
import com.to.entities.CarRentalDetails;

@RestController
public class CarRentalController {

	@Autowired
	private ICarRentalDao car;
	
	@RequestMapping(value="/car", method=RequestMethod.POST)
    public CarRentalDetails saveCar(@RequestBody CarRentalDetails reqCar) {
		car.persist(reqCar);
		return reqCar;
	}
	
	@RequestMapping(value="/car/{tripId}", method=RequestMethod.GET)
    public CarRentalDetails getCar(@PathVariable Long tripId) {
        return car.findByTripId(tripId);
    }
	
}
