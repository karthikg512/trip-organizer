package com.to.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.to.dao.IAccommodationDao;
import com.to.entities.AccommodationDetails;

@RestController
public class AccommodationController {
	
	@Autowired
	private IAccommodationDao accm;
	
	@RequestMapping(value="/accommodation", method=RequestMethod.POST)
    public AccommodationDetails saveAccm(@RequestBody AccommodationDetails reqAccm) {
		accm.persist(reqAccm);
		return reqAccm;
	}
	
	@RequestMapping(value="/accommodation/{tripId}", method=RequestMethod.GET)
    public AccommodationDetails getAccm(@PathVariable Long tripId) {
        return accm.findByTripId(tripId);
    }

}
