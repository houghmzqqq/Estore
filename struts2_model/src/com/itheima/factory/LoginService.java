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
	 *验证用户名密码
	 *@param username 用户名
	 *@param password 密码
	 *@return 
	 */
	public User login_service(String username,String password) throws MyException;
	
	/**
	 *获取商品集合
	 *@param ids 商品id数组
	 *@return commodities 商品List集合
	 */
	public List<Commodity> getCommoditysForCart(String[] ids);
	
	/**
	 *获取商品和数量的关系
	 *@param commodities 商品List集合
	 *@param counts 商品数量数组
	 *@return map 商品和数量的键值关系
	 * @throws MyException 
	 */
	public Map<Commodity, String> getMapForCart(List<Commodity> commodities,String[] counts) throws MyException;
}
