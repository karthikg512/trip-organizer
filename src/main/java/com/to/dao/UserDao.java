package com.to.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.to.entities.User;
import com.to.util.HibernateUtil;

@Repository
public class UserDao implements IUserDao {


	@Override
	public void persist(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save( user );
		session.getTransaction().commit();
		session.close();	
	}

	@Override
	public User find(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("id",id));
        return (User) criteria.uniqueResult();
	}

	@Override
	public User find(String emailId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("emailId",emailId));
        return (User) criteria.uniqueResult();
	}

}
