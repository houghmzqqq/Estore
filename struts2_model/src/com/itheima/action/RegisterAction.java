package com.itheima.action;

import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

import com.itheima.dao.UserDaoImpl;
import com.itheima.entity.User;
import com.itheima.factory.RegisterService;
import com.itheima.service.RegisterServiceImpl;
import com.itheima.test.Test01;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport implements ModelDriven<User>
{
	private User user;
	
	/**
	 *注册用户
	 *@param name
	 *@return 
	 */
	public String toRegister() throws Exception
	{
		//设置为未激活
		user.setIsActivation("未激活");
		//添加激活码
		String uuidCode = UUID.randomUUID().toString();
		user.setActivationCode(uuidCode);
		//设置角色
		user.setRole("普通用户");
		System.out.println(user.getUsername() + "," + user.getPassword() + "," + user.getEmail() + "," + user.getIsActivation()
				+ "," + user.getActivationCode() + "," + user.getRole());
		
		RegisterService register = new RegisterServiceImpl();
		register.register_service(user);
		
		return "toActive";
	}

	@Override
	public User getModel() 
	{
		if(user == null)
		{
			user = new User();
		}
		return user;
	}
}
