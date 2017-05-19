package com.itheima.factory;

import java.util.List;
import java.util.Map;

import com.itheima.entity.Commodity;
import com.itheima.entity.CommodityImg;
import com.itheima.exception.MyException;

public interface CommodityDao extends DaoFactory 
{
	/**
	 *������Ʒ��ͼƬ��Ϣ
	 *@param commodity ��Ʒʵ��
	 *@param comImg ͼƬʵ��
	 *@return null
	 */
	public void addCommodity_img(Commodity commodity,List<CommodityImg> comImgs);
	
	/**
	 *����������Ʒ�Լ���Ӧ��ͼƬ
	 *@return List<Commodity> ������Ʒ�ļ���
	 */
	public List<Commodity> findCommodity_img();
	
	/**
	 *ͨ��id��ȡ��Ʒ��Ϣ
	 *@param comm_id ��Ʒid
	 *@return commodity ��Ʒʵ��
	 * @throws MyException 
	 */
	public Commodity getCommInfoById(String comm_id) throws MyException;
}
