package com.itheima.factory;

import java.util.List;
import java.util.Map;

import org.junit.validator.PublicClassValidator;

import com.itheima.dao.LoginDaoImpl;
import com.itheima.entity.Commodity;
import com.itheima.entity.User;
import com.itheima.exception.MyException;

public interface LoginService extends ServiceFactory
{
	/**
	 *��֤�û�������
	 *@param username �û���
	 *@param password ����
	 *@return 
	 */
	public User login_service(String username,String password) throws MyException;
	
	/**
	 *��ȡ��Ʒ����
	 *@param ids ��Ʒid����
	 *@return commodities ��ƷList����
	 */
	public List<Commodity> getCommoditysForCart(String[] ids);
	
	/**
	 *��ȡ��Ʒ�������Ĺ�ϵ
	 *@param commodities ��ƷList����
	 *@param counts ��Ʒ��������
	 *@return map ��Ʒ�������ļ�ֵ��ϵ
	 * @throws MyException 
	 */
	public Map<Commodity, String> getMapForCart(List<Commodity> commodities,String[] counts) throws MyException;
}
