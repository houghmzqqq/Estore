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
			throw new MyException("δ�ҵ���ü�����ƥ����û���");
		}
		
		return user;
	}

}
