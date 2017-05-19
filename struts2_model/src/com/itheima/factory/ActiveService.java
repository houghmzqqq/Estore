package com.itheima.factory;

import com.itheima.entity.User;
import com.itheima.exception.MyException;

public interface ActiveService extends ServiceFactory
{
	/**
	 *激活用户
	 *@param activationCode 激活码
	 *@return user 用户实例
	 * @throws MyException 
	 */
	public User active_service(String activationCode) throws MyException;
}
