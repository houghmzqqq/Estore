package com.itheima.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;

import com.itheima.dao.CommodityDaoImpl;
import com.itheima.entity.Commodity;
import com.itheima.exception.MyException;
import com.itheima.factory.CommodityDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PutInCartAction extends ActionSupport 
{
	private String commodity_id;
	private String comm_count;
	public String getCommodity_id() {
		return commodity_id;
	}
	public void setCommodity_id(String commodity_id) {
		this.commodity_id = commodity_id;
	}
	public String getComm_count() {
		return comm_count;
	}
	public void setComm_count(String comm_count) {
		this.comm_count = comm_count;
	}
	
	public String putInCart()
	{
		// 购物车中的商品
		List<Commodity> commodities;
		//记录购物车中商品的数量
		Map<Commodity, String> map;
		Commodity commodity;
		ActionContext ac = ActionContext.getContext();
		StringBuffer commodity_ids = new StringBuffer();
		StringBuffer comm_counts = new StringBuffer();
		if (ac.getSession().get("user") != null)
		{
			try {
				CommodityDao commodityDao = new CommodityDaoImpl();
				
//				clearCart();
				
				//1、获取session中的购物车内容
				commodities = (List<Commodity>) ac.getSession().get("commoditys");
				map = (Map<Commodity, String>) ac.getSession().get("map");
				
				
				//输出测试
//				for(Commodity commodity2 : commodities)
//				{
//					System.out.println(commodity2.getName() + ":" + map.get(commodity2));
//				}
				
				if ((commodities==null || commodities.size()<=0) || (map==null || map.entrySet().size()<=0))
				{
					System.out.println("新的session内容/n");
					commodities = new ArrayList<Commodity>();
					map = new HashMap<Commodity, String>();
				} 
//				else 
//				{
//					commodities = (List<Commodity>) ac.getSession().get("commoditys");
//					map = (Map<Commodity, String>)ac.getSession().get("map");
//				}
				
				//2、将商品加入商品列表
				commodity = commodityDao.getCommInfoById(commodity_id);
				commodities.add(commodity);
				map.put(commodity, comm_count);
				
				//3、遍历购物车中的商品列表，获取商品id和数量
				for(Commodity commodity2 : commodities)
				{
						commodity_ids.append(","+commodity2.getId());
						comm_counts.append(","+map.get(commodity2));
				}
				
				//4、商品加入购物车中
				System.out.println("CartInfo--commoditys:" + commodities);
				System.out.println("CartInfo--map       :" + map);
				ac.getSession().put("commoditys", commodities);
				ac.getSession().put("map", map);
				
				//5、购物车信息保存到cookie中
				Cookie cookie1 = new Cookie("commodity_ids",commodity_ids.toString());
				Cookie cookie2 = new Cookie("comm_counts",comm_counts.toString());
				System.out.println("commodity_ids = " + commodity_ids.toString());
				System.out.println("comm_counts = " + comm_counts.toString());
				cookie1.setPath(ServletActionContext.getRequest().getContextPath());
				cookie2.setPath(ServletActionContext.getRequest().getContextPath());
				cookie1.setMaxAge(3600*24*30);
				cookie2.setMaxAge(3600*24*30);
				ServletActionContext.getResponse().addCookie(cookie1);
				ServletActionContext.getResponse().addCookie(cookie2);
				
			} catch (MyException e) {
				e.printStackTrace();
			} 
			return SUCCESS;
		}
		else
		{
			return "toLogin";
		}
	}
	
	public void clearCart()
	{
		ActionContext ac = ActionContext.getContext();
		//清除session中的商品和商品数量
		ac.getSession().remove("commoditys");
		ac.getSession().remove("map");
		
		//清除cookie中的信息
		Cookie cookie1 = new Cookie("commodity_ids","");
		Cookie cookie2 = new Cookie("comm_counts","");
		cookie1.setPath(ServletActionContext.getRequest().getContextPath());
		System.out.println(ServletActionContext.getRequest().getContextPath());
		cookie2.setPath(ServletActionContext.getRequest().getContextPath());
		cookie1.setMaxAge(0);
		cookie2.setMaxAge(0);
		ServletActionContext.getResponse().addCookie(cookie1);
		ServletActionContext.getResponse().addCookie(cookie2);
	}
	
	/**
	 *如果已登录，显示购物车；否则显示登录界面
	 *@return String
	 */
	public String showCart() throws Exception
	{
		ActionContext ac = ActionContext.getContext();
		if(ac.getSession().get("user") != null)
		{
			return "showCart";
		}
		return "toLogin";
	}
	
	/**
	 *删除购物车选项
	 *@return "showCart"
	 */
	public String deleteCart()
	{
		List<Commodity> commodities;
		Map<Commodity, String> map;
		StringBuffer commodity_ids = new StringBuffer();
		StringBuffer comm_counts = new StringBuffer();
		ActionContext ac = ActionContext.getContext();
		
		//1、获取session中的购物车内容
		commodities = (List<Commodity>) ac.getSession().get("commoditys");
		map = (Map<Commodity, String>) ac.getSession().get("map");
		
		//2、将点击的商品从购物车中删除
		for(Commodity commodity : commodities)
		{
			if (String.valueOf(commodity.getId()).equals(commodity_id))
			{
				commodities.remove(commodity);
				map.remove(commodity);
			}
			else
			{
				commodity_ids.append(","+commodity.getId());
				comm_counts.append(","+map.get(commodity));
			}
		}
		//3、购物车信息保存到cookie中
		Cookie cookie1 = new Cookie("commodity_ids",commodity_ids.toString());
		Cookie cookie2 = new Cookie("comm_counts",comm_counts.toString());
		cookie1.setPath(ServletActionContext.getRequest().getContextPath());
		cookie2.setPath(ServletActionContext.getRequest().getContextPath());
		cookie1.setMaxAge(3600*24*30);
		cookie2.setMaxAge(3600*24*30);
		ServletActionContext.getResponse().addCookie(cookie1);
		ServletActionContext.getResponse().addCookie(cookie2);
		
		return "showCart";
	}
}
