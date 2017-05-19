<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	 <title>Estore主页</title>
	 <meta charset="utf-8">
	 <link rel="stylesheet" type="text/css" href="css/index.css">
  </head>
  <body>
	<s:debug/>
  	<div id="page_top">
  		<div>
			<s:if test="#session.user==null">
				您好，请<a href="${pageContext.request.contextPath }/page_Login.jsp">登录</a>
			</s:if>
			<s:else>
				<a href="#">${sessionScope.user.username}</a>,欢迎您！/
				<a href="core_Logout.action">注销</a> 
			</s:else>
	  		<a href="#">我的订单</a> 
	  		<a href="showCart.action">购物车</a>
		</div>
		
	  	<div id="searchDiv">
	  		<form>
				<input type="text" name="search_info"/>
				<input type="submit" value="查找">
	  		</form>
	  	</div>
	  	<a href="add_Commodity.action">添加商品</a>
  	</div>
  	
  	<div>
  		<s:iterator value="#application.commoditys" var="commodity">
  			<div id="commodity_block">
				<img src="<s:property value='#commodity.comImgs.iterator().next().savepath'/>/<s:property value='#commodity.comImgs.iterator().next().uuidname'/>" 
				id="commodity_img" />
	  			<a href="commodity_info.action?commodity_id=<s:property value='#commodity.id'/>">
	  				<s:property value="#commodity.name"/>
	  			</a>
	  		</div>
  		</s:iterator>
	</div>
  </body>
</html>