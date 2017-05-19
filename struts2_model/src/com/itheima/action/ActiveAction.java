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
	 *用户通过本人发送的验证邮件访问该方法，进行激活
	 *@param name
	 *@return 逻辑视图名称
	 */
	public String toActive() throws Exception
	{
		ActiveService activeService = new ActiveServiceImpl();
		User user = activeService.active_service(activationCode);
		
		//登录用户
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("user", user);
		
		return SUCCESS;
	}
}
