<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0" />
		<title>Bootstrap响应式登录界面模板</title>
		
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/login.css"/>
	</head>
	
	<body>
	<s:debug/>
		<div class="box">
			<div class="login-box">
			
				<div class="login-title text-center">
					<h1><small>登录</small></h1>
				</div>
				
				<div class="login-content ">
					<div class="form">
						<form action="core_Login.action" method="post">
						
							<div class="form-group">
								<div class="col-xs-12  ">
									<div class="input-group">
										<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
										<input type="text" id="username" name="username" class="form-control" placeholder="用户名">
									</div>
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-xs-12  ">
									<div class="input-group">
										<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
										<input type="text" id="password" name="password" class="form-control" placeholder="密码">
									</div>
								</div>
							</div>
							
							
							<div class="form-group form-actions">
								<div class="col-xs-4 col-xs-offset-4 ">
									<p style="color:red;"><s:property value="exception.message"/></p>
									<button type="submit" class="btn btn-sm btn-info"><span class="glyphicon glyphicon-off"></span> 登录</button>
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-xs-6 link">
									<p class="text-center remove-margin"><small>忘记密码？</small> <a href="javascript:void(0)" ><small>找回</small></a>
									</p>
								</div>
								
								<div class="col-xs-6 link">
									<p class="text-center remove-margin"><small>还没注册?</small> <a href="${pageContext.request.contextPath }/page_Register.jsp" ><small>注册</small></a>
									</p>
								</div>
							</div>
							
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>