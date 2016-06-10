package com.to.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.to.entities.CarRentalDetails;
import com.to.util.HibernateUtil;

@Repository
public class CarRentalDao implements ICarRentalDao {

	@Override
	public void persist(CarRentalDetails car) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save( car );
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public CarRentalDetails findByTripId(Long tripId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(CarRentalDetails.class);
        criteria.add(Restrictions.eq("tripId",tripId));
        return (CarRentalDetails) criteria.uniqueResult();
	}

}
