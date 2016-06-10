package com.to.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.to.dao.ITripDao;
import com.to.entities.Trip;
import com.to.entities.TripDetails;

@RestController
public class TripController {
	
	@Autowired
	private ITripDao trip;
	
	@RequestMapping(value="/trip", method=RequestMethod.POST)
    public Trip saveTrip(@RequestBody Trip reqTrip) {
		trip.persist(reqTrip);
		return reqTrip;
	}
	
	@RequestMapping(value="/trip/{id}", method=RequestMethod.GET)
    public Trip getTrip(@PathVariable Long id) {
        return trip.find(id);
    }
	
	@RequestMapping(value="/trip/details/{id}", method=RequestMethod.GET)
    public TripDetails getTripDetails(@PathVariable Long id) {
        return trip.getDetails(id);
    }

}
