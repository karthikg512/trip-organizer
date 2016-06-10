package com.to.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.to.entities.AccommodationDetails;
import com.to.util.HibernateUtil;

@Repository
public class AccommodationDao implements IAccommodationDao {

	@Override
	public void persist(AccommodationDetails accm) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save( accm );
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public AccommodationDetails findByTripId(Long tripId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(AccommodationDetails.class);
        criteria.add(Restrictions.eq("tripId",tripId));
        return (AccommodationDetails) criteria.uniqueResult();
	}

}
