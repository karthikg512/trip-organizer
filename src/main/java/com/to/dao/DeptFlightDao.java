package com.to.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.to.entities.DeptFlightDetails;
import com.to.util.HibernateUtil;

@Repository
public class DeptFlightDao implements IDeptFlightDao {

	@Override
	public void persist(DeptFlightDetails deptFlt) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save( deptFlt );
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public DeptFlightDetails findByTripId(Long tripId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(DeptFlightDetails.class);
        criteria.add(Restrictions.eq("tripId",tripId));
        return (DeptFlightDetails) criteria.uniqueResult();
	}

}
