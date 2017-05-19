package com.itheima.factory;

import com.itheima.entity.User;

public interface UserDao extends DaoFactory 
{
	/**
	 *向数据库增加用户，保存信息
	 *@param User 用户实例
	 *@return null
	 */
	public void addUser(User user);
	
	/**
	 *将用户的 isActivaction字段修改为"已激活"
	 *@param activationCode 激活码
	 *@return User 用户实例
	 */
	public User activeUser(String activationCode);
}
