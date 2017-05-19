package com.itheima.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.itheima.entity.User;
import com.itheima.factory.LoginDao;
import com.itheima.util.HibernateUTIL;

public class LoginDaoImpl implements LoginDao
{
	public User findUser(String username)
	{
		
		Session session = HibernateUTIL.getSession();
		Transaction tx = session.beginTransaction();

		String hql = "select distinct u from User u where username=:name";
		List<User> list = session.createQuery(hql).setString("name",username).list();

		tx.commit();
		HibernateUTIL.closeSession(session);
		
		if(list.size() == 0)
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}
}
