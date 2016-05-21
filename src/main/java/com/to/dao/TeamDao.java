package com.to.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.to.entities.Team;
import com.to.entities.Trip;
import com.to.util.HibernateUtil;

@Repository
public class TeamDao implements ITeamDao {

	@Override
	public void persist(Team team) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save( team );
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Trip> find(Long userId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Team.class);
        criteria.add(Restrictions.eq("userId",userId));
        criteria.setProjection(Projections.property("tripId"));
        List<Long> listOfTripIds = criteria.list();

        // TODO: Join query
        List<Trip> listOfTrips = new ArrayList<Trip>();
        for (Long tripId : listOfTripIds) {
        	Criteria tripCriteria = session.createCriteria(Trip.class);
        	tripCriteria.add(Restrictions.eq("id",tripId));
        	listOfTrips.add((Trip) tripCriteria.uniqueResult());
        }
        
        System.out.println("list " + listOfTrips);
        return listOfTrips;
	}

}
