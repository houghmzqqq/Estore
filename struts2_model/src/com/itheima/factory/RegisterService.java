package com.itheima.factory;

import com.itheima.entity.User;

public interface RegisterService extends ServiceFactory 
{
	/**
	 *注册用户
	 *@param user 用户实例
	 *@return null
	 */
	public void register_service(User user);
	
	/**
	 *发送激活邮件
	 *@param myEmail 我的邮箱
	 *@param code 激活码
	 */
	public void sendEmail(String myEmail, String code);
}
