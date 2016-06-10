package com.to.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.to.dao.IDeptFlightDao;
import com.to.entities.DeptFlightDetails;

@RestController
public class DeptFlightController {
	
	@Autowired
	private IDeptFlightDao deptFlt;
	
	@RequestMapping(value="/deptFlight", method=RequestMethod.POST)
    public DeptFlightDetails saveDeptFlt(@RequestBody DeptFlightDetails reqDeptFlt) {
		deptFlt.persist(reqDeptFlt);
		return reqDeptFlt;
	}
	
	@RequestMapping(value="/deptFlight/{tripId}", method=RequestMethod.GET)
    public DeptFlightDetails getDeptFlt(@PathVariable Long tripId) {
        return deptFlt.findByTripId(tripId);
    }

}
