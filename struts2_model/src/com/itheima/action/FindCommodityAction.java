package com.itheima.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.itheima.dao.CommodityDaoImpl;
import com.itheima.entity.Commodity;
import com.itheima.entity.CommodityImg;
import com.itheima.factory.CommodityDao;
import com.itheima.factory.CommodityService;
import com.itheima.service.CommodityServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FindCommodityAction extends ActionSupport 
{
	public String findCommodity()
	{
		CommodityService commodityService = new CommodityServiceImpl();
		List<Commodity> commodities = commodityService.findComm_service();
		
		ActionContext ac = ActionContext.getContext();
		ac.getApplication().put("commoditys", commodities);
		
		for(Commodity commodity : commodities)
		{
//			System.out.println(commodity.getName()+":");
			
			Iterator<CommodityImg> comImgs = commodity.getComImgs().iterator();
//			while(comImgs.hasNext())
//			{
//				System.out.println("	--" + comImgs.next().getSavepath());
//			}
		}
		
		return SUCCESS;
	}
}
