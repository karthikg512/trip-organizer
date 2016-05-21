package com.to.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.to.entities.Trip;
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

}
