package com.to.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.to.dao.ITeamDao;
import com.to.entities.Team;
import com.to.entities.Trip;

@RestController
public class TeamController {
	
	@Autowired
	private ITeamDao team;
	
	@RequestMapping(value="/team", method=RequestMethod.POST)
    public Team addTeam(@RequestBody Team reqTeam) {
		team.persist(reqTeam);
		return reqTeam;
	}
	
	@RequestMapping(value="/team/{userId}", method=RequestMethod.GET)
    public List<Trip> getTrip(@PathVariable Long userId) {
        return team.find(userId);
    }

}
