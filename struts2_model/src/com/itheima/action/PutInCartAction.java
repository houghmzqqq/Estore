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
		// ���ﳵ�е���Ʒ
		List<Commodity> commodities;
		//��¼���ﳵ����Ʒ������
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
				
				//1����ȡsession�еĹ��ﳵ����
				commodities = (List<Commodity>) ac.getSession().get("commoditys");
				map = (Map<Commodity, String>) ac.getSession().get("map");
				
				
				//�������
//				for(Commodity commodity2 : commodities)
//				{
//					System.out.println(commodity2.getName() + ":" + map.get(commodity2));
//				}
				
				if ((commodities==null || commodities.size()<=0) || (map==null || map.entrySet().size()<=0))
				{
					System.out.println("�µ�session����/n");
					commodities = new ArrayList<Commodity>();
					map = new HashMap<Commodity, String>();
				} 
//				else 
//				{
//					commodities = (List<Commodity>) ac.getSession().get("commoditys");
//					map = (Map<Commodity, String>)ac.getSession().get("map");
//				}
				
				//2������Ʒ������Ʒ�б�
				commodity = commodityDao.getCommInfoById(commodity_id);
				commodities.add(commodity);
				map.put(commodity, comm_count);
				
				//3���������ﳵ�е���Ʒ�б���ȡ��Ʒid������
				for(Commodity commodity2 : commodities)
				{
						commodity_ids.append(","+commodity2.getId());
						comm_counts.append(","+map.get(commodity2));
				}
				
				//4����Ʒ���빺�ﳵ��
				System.out.println("CartInfo--commoditys:" + commodities);
				System.out.println("CartInfo--map       :" + map);
				ac.getSession().put("commoditys", commodities);
				ac.getSession().put("map", map);
				
				//5�����ﳵ��Ϣ���浽cookie��
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
		//���session�е���Ʒ����Ʒ����
		ac.getSession().remove("commoditys");
		ac.getSession().remove("map");
		
		//���cookie�е���Ϣ
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
	 *����ѵ�¼����ʾ���ﳵ��������ʾ��¼����
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
	 *ɾ�����ﳵѡ��
	 *@return "showCart"
	 */
	public String deleteCart()
	{
		List<Commodity> commodities;
		Map<Commodity, String> map;
		StringBuffer commodity_ids = new StringBuffer();
		StringBuffer comm_counts = new StringBuffer();
		ActionContext ac = ActionContext.getContext();
		
		//1����ȡsession�еĹ��ﳵ����
		commodities = (List<Commodity>) ac.getSession().get("commoditys");
		map = (Map<Commodity, String>) ac.getSession().get("map");
		
		//2�����������Ʒ�ӹ��ﳵ��ɾ��
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
		//3�����ﳵ��Ϣ���浽cookie��
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
