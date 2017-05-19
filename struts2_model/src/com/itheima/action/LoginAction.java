package com.itheima.action;

import com.itheima.entity.Commodity;
import com.itheima.exception.MyException;
import com.itheima.factory.LoginService;
import com.itheima.service.LoginServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.PreResultListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;



public class LoginAction extends ActionSupport 
{
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String toLogin() throws MyException
	{
		Commodity commodity = new Commodity();
		List<Commodity> commodities = new ArrayList<Commodity>();
		Map<Commodity, String > map = new HashMap<Commodity, String>();
		ActionContext ac = ActionContext.getContext();
		LoginService loginService = new LoginServiceImpl();
		
		//添加监听器
		ActionInvocation invocation = ac.getActionInvocation();
		invocation.addPreResultListener(new PreResultListener() {
			
			public void beforeResult(ActionInvocation arg0, String arg1)
			{
				System.out.println("返回的逻辑视图名称："+arg1);
			}
		});
		
		
		//获取cookie信息，读取购物车信息
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		
		if (cookies != null && cookies.length > 0)
		{
			String[] ids;
			String[] counts;
			for (Cookie cookie : cookies) 
			{
				//获取名为"commodity_ids"的cookie
				if(cookie.getName().equals("commodity_ids"))
				{
					ids = cookie.getValue().split(",");
					if(ids.length > 0)
					{
						commodities = loginService.getCommoditysForCart(ids);
					}
				}
				
				System.out.println(cookie.getName() + ":" + cookie.getValue());
			}
			
			for(Cookie cookie : cookies)
			{
				//获取comm_counts的cookie
				if(cookie.getName().equals("comm_counts"))
				{
					counts = cookie.getValue().split(",");
					System.out.println(cookie.getValue());
					if(counts.length > 0)
					{
						map = loginService.getMapForCart(commodities, counts);
					}
				}
			}
			
		}
		
		ac.getSession().put("user", loginService.login_service(username, password));
		ac.getSession().put("commoditys", commodities);
		ac.getSession().put("map", map);
		
		return SUCCESS;
	}
}
