<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
  <title><s:property value="#commodity.name"/>详细信息</title>
  <link rel="stylesheet" href="css/image_1.css" type="text/css" />
  <meta name="generator" content="editplus" />
  <script type="text/javascript" src="js/jquery-2.0.0.min.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){

	    var img_count ;
	    var path ;/*= $("img[mynum="+img_count+"]").attr("src");*/

	  		// 点击左箭头
	  		$("#left_row").click(function(){
	  			if($("#image_big").attr("class") == 1)
	  			{
	  				img_count = $("#image_div").find("img").length;
	  			}
	  			else
	  			{
	  				img_count = $("#image_big").attr("class") - 1;
	  			}
	        	path = $("img[mynum="+img_count+"]").attr("src");
				$("#image_big").attr("src",path);
				$("#image_big").attr("class",img_count);
	  		})

	  		// 点击右箭头
	  		$("#right_row").click(function(){
	  			if($("#image_big").attr("class") == $("#image_div").find("img").length)
	  			{
	  				img_count = 1;
	  			}
	  			else
	  			{
	  				img_count = parseInt($("#image_big").attr("class")) + 1;
	  			}
		        path = $("img[mynum="+img_count+"]").attr("src");
		        $("#image_big").attr("src",path);
	  			$("#image_big").attr("class",img_count);
	  		})

	  		// 点击上面的小图片
	  		$(".img").click(function(){
	        	path = $(this).attr("src");
	  			var i = $(this).attr("mynum");
	  			$("#image_big").attr("src",path);
	  			$("#image_big").attr("class",i);
	  		})

	  		//增加和减少商品数量
	  		$("#down_bt").click(function(){
	  			var i = parseInt($("#c_num").attr("value"));
	  			if(i > 0)
	  			{
	  				i = i - 1;
	  			}
	  			$("#c_num").attr("value",i);
	  		})
	  		$("#up_bt").click(function(){
	  			var i = parseInt($("#c_num").attr("value"));
	  			i = i + 1;
	  			$("#c_num").attr("value",i);
	  		})
	  	})
  </script>
  <script type="text/javascript">
  	function buyNow()
  	{
  		document.commForm.action="#";
  	}
  
  	function inCart()
  	{
  		document.commForm.action="putInCart.action";
  	}
  	
  	
  </script>
 </head> 

 <body>
 <s:debug/>
	<div id="image_gundong">
	  	<div id="image_big_div">
	  		<div id="leftDiv">
	  			<button id="left_row"></button>
	  		</div>
	  		<img class="1" id="image_big" 
	  		src="<s:property value='#request.commodity.comImgs.iterator().next().savepath'/>/<s:property value='#request.commodity.comImgs.iterator().next().uuidname'/>">
	  		<div id="rightDiv">
	  			<button id="right_row"></button>
	  		</div>
	  	</div>
	
	    <div id="image_div">
	    	<s:iterator value="#request.commodity.comImgs" var="comImg" status="ci">
	      		<img class="img" src="<s:property 
	      		value='#comImg.savepath'/>/<s:property value='#comImg.uuidname'/>" 
	      		mynum="<s:property value='#ci.count'/>"/>
	    	</s:iterator>
	    </div>
  	</div>
  	<div id="text_info">
	  	<s:property value="#commodity.name"/><br/>
	  	库存：<s:property value="#commodity.stock"/><br/>
	  	单价：<s:property value="#commodity.unitPrice"/><br/>
	  	<form name="commForm" action="#" method="post">
	  		<input type="hidden" name="commodity_id" value="<s:property value='#commodity.id'/>"/>
	  		
		  	<input id="down_bt" type="button" value="-"/>
			<input id="c_num" name="comm_count" value="1"/>
		  	<input id="up_bt" type="button" value="+"/><br/>
		  	
		  	<input type="submit" value="立即购买" onclick="buyNow()"/> <input type="submit" value="加入购物车" onclick="inCart()"/>
	  	</form>
  	</div>
 </body>
</html>