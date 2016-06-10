package com.to.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.to.entities.ArrFlightDetails;
import com.to.util.HibernateUtil;

@Repository
public class ArrFlightDao implements IArrFlightDao {

	@Override
	public void persist(ArrFlightDetails arrFlt) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save( arrFlt );
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public ArrFlightDetails findByTripId(Long tripId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(ArrFlightDetails.class);
        criteria.add(Restrictions.eq("tripId",tripId));
        return (ArrFlightDetails) criteria.uniqueResult();
	}

}
