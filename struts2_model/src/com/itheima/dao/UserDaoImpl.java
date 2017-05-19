package com.itheima.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.itheima.entity.User;
import com.itheima.factory.UserDao;
import com.itheima.util.HibernateUTIL;

public class UserDaoImpl implements UserDao
{
	public void addUser(User user)
	{
		Session session = HibernateUTIL.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(user);
		
		tx.commit();
		HibernateUTIL.closeSession(session);
		
	}

	public User activeUser(String activationCode) 
	{
		Session session = HibernateUTIL.getSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "from User u where u.activationCode=:code";
		List<User> users = session.createQuery(hql).setString("code", activationCode).list();
		
		User user = null;
		if (users.size() > 0) 
		{
			user = users.get(0);
			user.setIsActivation("ÒÑ¼¤»î");
			session.update(user);
		}
		
		tx.commit();
		HibernateUTIL.closeSession(session);
		
		return user;
	}
}
