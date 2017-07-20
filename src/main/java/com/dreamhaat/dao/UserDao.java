package com.dreamhaat.dao;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dreamhaat.model.User;
import com.dreamhaat.model.UserCredentials;


@Repository
public class UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insert(User user) {
		Session session =sessionFactory.openSession();
		
		System.out.println("Insert Method Called for UserDetails");
		Transaction tx=session.getTransaction();
		tx.begin();
		session.save(user);
		session.flush();
		tx.commit();
		session.close();
   }

	public void insertcreden(UserCredentials userCreden) {
        Session session =sessionFactory.openSession();
		System.out.println("Insert Method Called for UserCredentaials");
		Transaction tx=session.getTransaction();
		tx.begin();
		session.save(userCreden);
		session.flush();
		tx.commit();
		session.close();
	}
	public String address(String uname) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(User.class);
		String addr = ((User) cr.add(Restrictions.like("Username", uname)).list().get(0)).getAddress();
		session.close();
		return addr;

	}
	public String email(String uname) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(User.class);
		String email = ((User) cr.add(Restrictions.like("Username", uname)).list().get(0)).getEmailid();
		session.close();
		return email;

	}
	public String Mobile(String uname) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(User.class);
		String mobile = ((User) cr.add(Restrictions.like("Username", uname)).list().get(0)).getMobile();
		session.close();
		return mobile;

	}
	public User display(String uname)
	{
		Session session = sessionFactory.openSession();
		System.out.println(uname);
		Criteria cr=session.createCriteria(User.class);
		User ru=(User)cr.add(Restrictions.like("Username",uname)).list().get(0);
		session.close();
		return ru;

}

	

}