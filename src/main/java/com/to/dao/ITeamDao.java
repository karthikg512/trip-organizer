package com.to.dao;

import java.util.List;

import com.to.entities.Team;
import com.to.entities.Trip;

public interface ITeamDao {

	void persist(Team reqTeam);

	List<Trip> find(Long userId);

}
