package com.itheima.test;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.itheima.entity.Commodity;
import com.itheima.entity.OrderItem;
import com.itheima.entity.TheOrder;
import com.itheima.entity.User;
import com.itheima.util.HibernateUTIL;

public class Test01
{
	@Test
	public void test()
	{
		Session session = HibernateUTIL.getSession();
		Transaction tx = session.beginTransaction();
		
//		User user = new User();
//		TheOrder order = new TheOrder();
//		Commodity commodity = new Commodity("�����", "����", "100", 49.9);
//		OrderItem orderItem = new OrderItem(3, order, commodity);
//		
//		user.setUsername("����");
//		user.setPassword("123");
//		user.setEmail("87043521@qq.com");
//		user.setIsActivation("δ����");
//		user.setActivationCode("123456");
//		user.setRole("��ͨ�û�");
//		
//		order.setDown_time(new Date(2017, 4, 22));
//		order.setAddress("�㶫�����ѧ");
//		order.setIsPay("δ֧��");
//		order.setAmount_of_money(50);
//		order.setUser(user);
//		
//		session.persist(user);
//		session.persist(order);
//		session.persist(commodity);
//		session.persist(orderItem);
		
		User user = null;
		List<User> u1 = session.createQuery("select distinct u from User u where u.username = :name").setString("name", "����").list();
		for(User u : u1)
		{
			user = u;
			System.out.println(user);
		}
		
		tx.commit();
		HibernateUTIL.closeSession(session);
	}
}
