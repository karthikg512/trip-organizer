package com.to.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.to.entities.Activities;
import com.to.util.HibernateUtil;

@Repository
public class ActivitiesDao implements IActivitiesDao {

	@Override
	public void persist(Activities acct) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save( acct );
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public Activities findByTripId(Long tripId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Activities.class);
        criteria.add(Restrictions.eq("tripId",tripId));
        return (Activities) criteria.uniqueResult();
	}

}
