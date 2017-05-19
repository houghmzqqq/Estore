package com.itheima.factory;

import com.itheima.entity.User;

public interface LoginDao extends DaoFactory
{
	/**
	 *查询用户
	 *@param username 用户名
	 *@return User 用户实例
	 */
	public User findUser(String username);
}
