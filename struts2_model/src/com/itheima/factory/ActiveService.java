package com.itheima.factory;

import com.itheima.entity.User;
import com.itheima.exception.MyException;

public interface ActiveService extends ServiceFactory
{
	/**
	 *�����û�
	 *@param activationCode ������
	 *@return user �û�ʵ��
	 * @throws MyException 
	 */
	public User active_service(String activationCode) throws MyException;
}
