<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	 <title>购物车</title>
	 <link rel="stylesheet" href="css/image_1.css" type="text/css" />
  </head>
  <body>
  <s:debug></s:debug>
  	<table style="border:1px;">
  		<tr>
  			<th>商品信息</th>
  			<th>单价</th>
  			<th>数量</th>
  			<th>金额</th>
  			<th>操作</th>
  		</tr>
		<s:iterator value="#session.commoditys" id="commodity">
			<tr>
		 		<th><img class="img" alt="<s:property value='#commodity.name'/>" 
		 		src="<s:property value='#commodity.comImgs.iterator().next().savepath'/>/<s:property value='#commodity.comImgs.iterator().next().uuidname'/>">
		 		<br/><a href="commodity_info.action?commodity_id=<s:property value='#commodity.id'/>"><s:property value="#commodity.name"/></a></th>
		 		<th><s:property value="#commodity.unitPrice"/></th>
		 		<th><s:property value="#session.get('map').get(#commodity)"/></th>
		 		<th><s:property value="#commodity.unitPrice * #session.get('map').get(#commodity)"/></th>
		 		<th><a href="deleteCart.action?commodity_id=<s:property value='#commodity.id'/>">删除</a></th>
		 	</tr>
		</s:iterator>
  	</table>
  </body>
</html>