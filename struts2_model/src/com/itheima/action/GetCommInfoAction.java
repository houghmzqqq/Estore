package com.itheima.action;

import org.junit.Test;

import com.itheima.dao.CommodityDaoImpl;
import com.itheima.entity.Commodity;
import com.itheima.entity.CommodityImg;
import com.itheima.factory.CommodityDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetCommInfoAction extends ActionSupport 
{
	private String commodity_id;
	
	public String getCommodity_id()
	{
		return commodity_id;
	}
	public void setCommodity_id(String commodity_id)
	{
		this.commodity_id = commodity_id;
	}
	
	public String getCommInfo() throws Exception
	{
		CommodityDao commodityDao = new CommodityDaoImpl();
		Commodity commodity = commodityDao.getCommInfoById(commodity_id);
		
		ActionContext.getContext().put("commodity", commodity);
		
		return "CommInfo";
	}
	
}
