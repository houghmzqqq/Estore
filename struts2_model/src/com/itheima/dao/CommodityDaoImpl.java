package com.itheima.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.itheima.entity.Commodity;
import com.itheima.entity.CommodityImg;
import com.itheima.exception.MyException;
import com.itheima.factory.CommodityDao;
import com.itheima.util.HibernateUTIL;

public class CommodityDaoImpl implements CommodityDao
{
	private Session session;
	private Transaction tx;
	@Override
	public void addCommodity_img(Commodity commodity, List<CommodityImg> comImgs) 
	{
		session = HibernateUTIL.getSession();
		tx = session.beginTransaction();
		
		session.save(commodity);
		
		for(CommodityImg comImg : comImgs)
		{
			comImg.setCommodity(commodity);
			session.save(comImg);
		}
		
		
		tx.commit();
		HibernateUTIL.closeSession(session);
		
	}

	@Override
	public List<Commodity> findCommodity_img() 
	{
		session = HibernateUTIL.getSession();
		tx = session.beginTransaction();
		Map<Commodity, List<CommodityImg>> map = new HashMap<Commodity, List<CommodityImg>>();
		
		String hql = "from Commodity";
		List<Commodity> commodities = session.createQuery(hql).list();
		
		for(Commodity com : commodities)
		{
//			System.out.println(com+":");
			for(CommodityImg comImg : com.getComImgs())
			{
//				System.out.println(comImg);
			}
//			System.out.println("");
		}
		
		tx.commit();
		HibernateUTIL.closeSession(session);
		
		return commodities;
	}
	
	public Commodity getCommInfoById(String comm_id) throws MyException
	{
		session = HibernateUTIL.getSession();
		tx = session.beginTransaction();
		Commodity commodity;
		
		List<Commodity> list = session.createQuery("from Commodity c where commodity_id=:id").setString("id",comm_id).list();

		
		if (list.size() < 1)
		{
			throw new MyException("该商品已被下架！");
		}
		else
		{
			commodity = list.get(0);
			for(CommodityImg comImg : commodity.getComImgs())
			{
//				System.out.println(comImg);
			}
		}
		
		tx.commit();
		HibernateUTIL.closeSession(session);

		return commodity;
	}
}
