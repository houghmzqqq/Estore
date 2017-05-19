package com.itheima.action;

import com.itheima.dao.UserDaoImpl;
import com.itheima.entity.User;
import com.itheima.factory.ActiveService;
import com.itheima.factory.UserDao;
import com.itheima.service.ActiveServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActiveAction extends ActionSupport
{
	private String activationCode;

	public String getActivationCode() {
		return activationCode;
	}
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	
	/**
	 *�û�ͨ�����˷��͵���֤�ʼ����ʸ÷��������м���
	 *@param name
	 *@return �߼���ͼ����
	 */
	public String toActive() throws Exception
	{
		ActiveService activeService = new ActiveServiceImpl();
		User user = activeService.active_service(activationCode);
		
		//��¼�û�
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("user", user);
		
		return SUCCESS;
	}
}
