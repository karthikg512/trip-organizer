package com.to.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.to.entities.AccommodationDetails;
import com.to.entities.Activities;
import com.to.entities.ArrFlightDetails;
import com.to.entities.CarRentalDetails;
import com.to.entities.DeptFlightDetails;
import com.to.entities.Trip;
import com.to.entities.TripDetails;
import com.to.util.HibernateUtil;

@Repository
public class TripDao implements ITripDao {

	@Override
	public void persist(Trip trip) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save( trip );
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Trip find(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Trip.class);
        criteria.add(Restrictions.eq("id",id));
        return (Trip) criteria.uniqueResult();
	}

	@Override
	public TripDetails getDetails(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		TripDetails td = new TripDetails();

		Criteria ad = session.createCriteria(AccommodationDetails.class);
		ad.add(Restrictions.eq("tripId",id));
		td.setAccommDetails((AccommodationDetails) ad.uniqueResult());
		
		Criteria act = session.createCriteria(Activities.class);
		act.add(Restrictions.eq("tripId",id));
		td.setActivities((Activities) act.uniqueResult());
		
		Criteria arr = session.createCriteria(ArrFlightDetails.class);
		arr.add(Restrictions.eq("tripId",id));
		td.setArrFlightDetails((ArrFlightDetails) arr.uniqueResult());
		
		Criteria cr = session.createCriteria(CarRentalDetails.class);
		cr.add(Restrictions.eq("tripId",id));
		td.setCarRental((CarRentalDetails) cr.uniqueResult());
		
		Criteria dept = session.createCriteria(DeptFlightDetails.class);
		dept.add(Restrictions.eq("tripId",id));
		td.setDeptFlightDetails((DeptFlightDetails) dept.uniqueResult());
		
//		Criteria users = session.createCriteria(Team.class);
//		users.add(Restrictions.eq("tripId",id));
//		td.setUsers((List<Team>) users.list());
		
		Criteria criteria = session.createCriteria(Trip.class);
        criteria.add(Restrictions.eq("id",id));
        td.setTrip((Trip) criteria.uniqueResult());
		
		return td;
	}

}
