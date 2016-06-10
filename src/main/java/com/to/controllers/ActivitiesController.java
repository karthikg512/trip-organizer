package com.to.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.to.dao.IActivitiesDao;
import com.to.entities.Activities;

@RestController
public class ActivitiesController {
	
	@Autowired
	private IActivitiesDao acct;
	
	@RequestMapping(value="/activity", method=RequestMethod.POST)
    public Activities saveAcct(@RequestBody Activities reqAcct) {
		acct.persist(reqAcct);
		return reqAcct;
	}
	
	@RequestMapping(value="/activity/{tripId}", method=RequestMethod.GET)
    public Activities getAcct(@PathVariable Long tripId) {
        return acct.findByTripId(tripId);
    }

}
