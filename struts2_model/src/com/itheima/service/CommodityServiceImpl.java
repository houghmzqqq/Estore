package com.itheima.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.itheima.dao.CommodityDaoImpl;
import com.itheima.entity.Commodity;
import com.itheima.entity.CommodityImg;
import com.itheima.factory.CommodityDao;
import com.itheima.factory.CommodityService;

public class CommodityServiceImpl implements CommodityService 
{
	private CommodityDao commodityDao;
	public void addComm_service(Commodity commodity,List<CommodityImg> comImgs,String[] img)
	{
		commodityDao = new CommodityDaoImpl();
		commodityDao.addCommodity_img(commodity, comImgs);
		
		
		try 
		{
			for (int i=0; i<img.length; i++) 
			{
				//获取真实路径
				//将图片保存在Eclipse工作目录下
				String upload = "D:\\EclipseJavaWorkspace\\struts2_model\\WebContent\\" + comImgs.get(i).getSavepath().replace("/", "\\");
//				System.out.println(upload);
				
				//将图片保存在Tomcat中，由于工程重新部署时，Tomcat会删除原来的应用新建一个，会将原来的图片信息删除
//				String upload = ServletActionContext.getServletContext().getRealPath(comImgs.get(i).getSavepath());
				//如果路径下没有该文件夹，则创建一个
				new File(upload).mkdirs();
				FileOutputStream fos = new FileOutputStream(new File(upload, comImgs.get(i).getUuidname()));
				FileInputStream fis = new FileInputStream(img[i]);
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = fis.read(buffer)) > 0) 
				{
					fos.write(buffer, 0, len);
				} 
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public List<Commodity> findComm_service()
	{
		commodityDao = new CommodityDaoImpl();
		//所有商品信息放在map中，其中Commodity为商品，List<CommodityImg>为商品对应的图片集合
		List<Commodity> commodities = commodityDao.findCommodity_img();
		
//		//图片保存的真是路径
//		for(Commodity commodity : commodities)
//		{
//			for(CommodityImg comImg : commodity.getComImgs())
//			{
//				comImg.setSavepath(ServletActionContext.getServletContext().getRealPath(comImg.getSavepath() ) );
//			}
//		}
		
		return commodities;
	}
}
