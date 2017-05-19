package com.itheima.factory;

import java.util.List;
import java.util.Map;

import com.itheima.entity.Commodity;
import com.itheima.entity.CommodityImg;
import com.itheima.exception.MyException;

public interface CommodityDao extends DaoFactory 
{
	/**
	 *保存商品和图片信息
	 *@param commodity 商品实例
	 *@param comImg 图片实例
	 *@return null
	 */
	public void addCommodity_img(Commodity commodity,List<CommodityImg> comImgs);
	
	/**
	 *查找所有商品以及对应的图片
	 *@return List<Commodity> 所有商品的集合
	 */
	public List<Commodity> findCommodity_img();
	
	/**
	 *通过id获取商品信息
	 *@param comm_id 商品id
	 *@return commodity 商品实例
	 * @throws MyException 
	 */
	public Commodity getCommInfoById(String comm_id) throws MyException;
}
