package com.itheima.factory;

import com.itheima.entity.User;

public interface LoginDao extends DaoFactory
{
	/**
	 *��ѯ�û�
	 *@param username �û���
	 *@return User �û�ʵ��
	 */
	public User findUser(String username);
}
