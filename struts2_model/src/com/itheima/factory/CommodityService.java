package com.itheima.factory;

import java.util.List;
import java.util.Map;

import org.apache.struts2.components.File;

import com.itheima.entity.Commodity;
import com.itheima.entity.CommodityImg;

public interface CommodityService extends ServiceFactory 
{
	/**
	 *增加商品和商品图片
	 *@param commodity 商品实例
	 *@param comImg	商品图片实例
	 *@param file	文件路径
	 *@return null
	 */
	public void addComm_service(Commodity commodity,List<CommodityImg> comImgs,String[] img);
	
	/**
	 *搜索所有商品和对应的图片
	 *@param name
	 *@return List<Commodity> 所有商品的集合
	 */
	public List<Commodity> findComm_service();
}
