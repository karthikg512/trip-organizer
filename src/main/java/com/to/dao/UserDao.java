package com.to.dao;

import org.hibernate.Session;

import com.to.entities.User;
import com.to.util.HibernateUtil;

public class UserDao implements IUserDao {


	@Override
	public void persist(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save( user );
		session.getTransaction().commit();
		session.close();	
	}

}
