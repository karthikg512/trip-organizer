package com.to.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.to.dao.IArrFlightDao;
import com.to.entities.ArrFlightDetails;

@RestController
public class ArrFlightController {
	
	@Autowired
	private IArrFlightDao arrFlt;
	
	@RequestMapping(value="/arrFlight", method=RequestMethod.POST)
    public ArrFlightDetails saveArrFlt(@RequestBody ArrFlightDetails reqArrFlt) {
		arrFlt.persist(reqArrFlt);
		return reqArrFlt;
	}
	
	@RequestMapping(value="/arrFlight/{tripId}", method=RequestMethod.GET)
    public ArrFlightDetails getArrFlt(@PathVariable Long tripId) {
        return arrFlt.findByTripId(tripId);
    }

}
