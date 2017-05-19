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
				//��ȡ��ʵ·��
				//��ͼƬ������Eclipse����Ŀ¼��
				String upload = "D:\\EclipseJavaWorkspace\\struts2_model\\WebContent\\" + comImgs.get(i).getSavepath().replace("/", "\\");
//				System.out.println(upload);
				
				//��ͼƬ������Tomcat�У����ڹ������²���ʱ��Tomcat��ɾ��ԭ����Ӧ���½�һ�����Ὣԭ����ͼƬ��Ϣɾ��
//				String upload = ServletActionContext.getServletContext().getRealPath(comImgs.get(i).getSavepath());
				//���·����û�и��ļ��У��򴴽�һ��
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
		//������Ʒ��Ϣ����map�У�����CommodityΪ��Ʒ��List<CommodityImg>Ϊ��Ʒ��Ӧ��ͼƬ����
		List<Commodity> commodities = commodityDao.findCommodity_img();
		
//		//ͼƬ���������·��
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
