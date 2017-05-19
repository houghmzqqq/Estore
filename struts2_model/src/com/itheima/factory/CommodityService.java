package com.itheima.factory;

import java.util.List;
import java.util.Map;

import org.apache.struts2.components.File;

import com.itheima.entity.Commodity;
import com.itheima.entity.CommodityImg;

public interface CommodityService extends ServiceFactory 
{
	/**
	 *������Ʒ����ƷͼƬ
	 *@param commodity ��Ʒʵ��
	 *@param comImg	��ƷͼƬʵ��
	 *@param file	�ļ�·��
	 *@return null
	 */
	public void addComm_service(Commodity commodity,List<CommodityImg> comImgs,String[] img);
	
	/**
	 *����������Ʒ�Ͷ�Ӧ��ͼƬ
	 *@param name
	 *@return List<Commodity> ������Ʒ�ļ���
	 */
	public List<Commodity> findComm_service();
}
