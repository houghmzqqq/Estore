package com.itheima.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itheima.dao.CommodityDaoImpl;
import com.itheima.dao.LoginDaoImpl;
import com.itheima.entity.Commodity;
import com.itheima.entity.User;
import com.itheima.exception.MyException;
import com.itheima.factory.CommodityDao;
import com.itheima.factory.DaoFactory;
import com.itheima.factory.LoginDao;
import com.itheima.factory.LoginService;

public class LoginServiceImpl implements LoginService 
{

	@Override
	public User login_service(String username, String password) throws MyException
	{
		LoginDao loginDao = new LoginDaoImpl();
		User user = ( loginDao).findUser(username);
		
		if (user == null)
		{
			throw new MyException("用户名不存在！");
		}
		else if(user != null && !user.getPassword().equals(password))
		{
			System.out.println(user.getPassword() + ":" + password);
			throw new MyException("密码不正确，请重试！");
		}
		else /*if(user != null && user.getPassword().equals(password))*/
		{
			return user;
		}
	}

	@Override
	public List<Commodity> getCommoditysForCart(String[] ids) 
	{
		List<Commodity> commodities = new ArrayList<Commodity>();
		try 
		{
			for(String id : ids)
			{
				if(id != null && !id.equals(""))
				{
					CommodityDao commodityDao = new CommodityDaoImpl();
					commodities.add(commodityDao.getCommInfoById(id));
					System.out.println("商品"+commodityDao.getCommInfoById(id).toString());
				}
			}
		}
		catch (MyException e)
		{
			e.printStackTrace();
		}
		return commodities;
	}

	@Override
	public Map<Commodity, String> getMapForCart(List<Commodity> commodities, String[] counts) throws MyException 
	{
		Map<Commodity, String> map = new HashMap<Commodity, String>();
		System.out.println("commodities.size:" + commodities.size() + "-- counts.length:" + counts.length);
		if(commodities.size() == counts.length-1)
		{
			for(int i=0;i<commodities.size();i++)
			{
				int j = 0;
				if(counts[i] == null && counts[i].equals(""))
				{
					j = j + 1;
				}
				
				map.put(commodities.get(i),counts[j]);
				j++;
			}
		}
		else
		{
			throw new MyException("购物车数据异常：商品个数与商品数量个数不一致！请清除cookie缓存！");
		}
		return map;
	}

	
}
