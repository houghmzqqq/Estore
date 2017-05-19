package com.itheima.service;

import com.itheima.dao.UserDaoImpl;
import com.itheima.entity.User;
import com.itheima.exception.MyException;
import com.itheima.factory.ActiveService;
import com.itheima.factory.UserDao;

public class ActiveServiceImpl implements ActiveService
{

	@Override
	public User active_service(String activationCode) throws MyException
	{
		UserDao userDao = new UserDaoImpl();
		User user = userDao.activeUser(activationCode);
		
		if(user == null)
		{
			throw new MyException("未找到与该激活码匹配的用户！");
		}
		
		return user;
	}

}
