package com.itheima.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.itheima.dao.UserDaoImpl;
import com.itheima.entity.User;
import com.itheima.factory.RegisterService;
import com.itheima.factory.UserDao;

public class RegisterServiceImpl implements RegisterService
{

	@Override
	public void register_service(User user) 
	{
		UserDao userdao = new UserDaoImpl();
		userdao.addUser(user);
		
		sendEmail(user.getEmail(),user.getActivationCode());
	}

	@Override
	public void sendEmail(String myEmail, String code)
	{
		try
		{
			Properties props = new Properties();
			props.put("username","yejunfeng95@163.com");
			props.put("password","047878a548787s");
			props.put("mail.transport.protocol","smtp");
			props.put("mail.smtp.host","smtp.163.com");
			props.put("mail.smtp.port","25");
			props.put("mail.smtp.auth", "true");
			
			Session mailSession = Session.getDefaultInstance(props); 
			
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress("yejunfeng95@163.com"));
			msg.addRecipients(Message.RecipientType.TO, InternetAddress.parse(myEmail));
			msg.setSubject("�����ʼ�");
			msg.setContent("<h1>���ʼ�Ϊ�ٷ������ʼ�����������������ɼ��������</h1>"
					+ "<h3><a href='http://localhost/struts2_model/core_Active.action?activationCode="+code+"'"
					+ ">���Ҽ����û�</a></h3>","text/html;charset=UTF-8");
			msg.saveChanges();
			
			Transport transport = mailSession.getTransport();
			transport.connect(props.getProperty("mail.smtp.host"),
					props.getProperty("username"),
					props.getProperty("password"));
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}

}
