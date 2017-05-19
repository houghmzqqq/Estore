package com.itheima.factory;

import com.itheima.entity.User;

public interface UserDao extends DaoFactory 
{
	/**
	 *�����ݿ������û���������Ϣ
	 *@param User �û�ʵ��
	 *@return null
	 */
	public void addUser(User user);
	
	/**
	 *���û��� isActivaction�ֶ��޸�Ϊ"�Ѽ���"
	 *@param activationCode ������
	 *@return User �û�ʵ��
	 */
	public User activeUser(String activationCode);
}
