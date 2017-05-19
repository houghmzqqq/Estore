<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>添加商品</title>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="css/index.css">
	</head>
	<body>
		<form action="store_addCommodity.action" method="post" enctype="multipart/form-data">
			<table border="1">
				<tr>
					<th>商品名称</th>
					<th><input type="text" name="name"></th>
				</tr>
				<tr>
					<th>商品种类</th>
					<th>
						<select name="type" style="width: 100%;">
							<option value="电子产品">电子产品</option>
							<option value="书籍">书籍</option>
							<option value="家用电器">家用电器</option>
							<option value="食品">食品</option>
							<option value="工具">工具</option>
						</select>
					</th>
				</tr>
				<tr>
					<th>商品库存</th>
					<th><input type="text" name="stock"></th>
				</tr>
				<tr>
					<th>商品单价</th>
					<th><input type="text" name="unitPrice"></th>
				</tr>
				<tr>
					<th colspan="2"><input type="file" name="img"></th>
				</tr>
				<tr>
					<th colspan="2"><input type="file" name="img"></th>
				</tr>
				<tr>
					<th colspan="2"><input type="file" name="img"></th>
				</tr>
			</table>
			<input type="submit" value="添加">
		</form>
	</body>
</html>