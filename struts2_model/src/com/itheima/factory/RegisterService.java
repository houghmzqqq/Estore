package com.itheima.factory;

import com.itheima.entity.User;

public interface RegisterService extends ServiceFactory 
{
	/**
	 *ע���û�
	 *@param user �û�ʵ��
	 *@return null
	 */
	public void register_service(User user);
	
	/**
	 *���ͼ����ʼ�
	 *@param myEmail �ҵ�����
	 *@param code ������
	 */
	public void sendEmail(String myEmail, String code);
}
