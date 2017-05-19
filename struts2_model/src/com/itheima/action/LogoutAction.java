package com.itheima.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport 
{
	public String toLogout()
	{
		ServletActionContext.getRequest().getSession().invalidate();
//		ActionContext.getContext().getSession().clear();
		return "toLogout";
	}
}
