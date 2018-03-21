<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="left">
		<div id="left-top">
			<p style="padding-top:10px;">
				<a href="user_list" >用户管理</a>
				<hr style="border:1px;border-top:1px solid black;">
			</p>
			<p>
				<a href="order_list">订单管理</a>
				<hr style="border:1px;border-top:1px solid black;">
			</p>
			<p>
				<a href="product_list" >商品管理</a>
			    <hr style="border:1px;border-top:1px solid black;margin:14px 0px 0px 0px;padding:6px;">
			</p>
			<p>
				<a href="productType_list">商品类型管理</a>
				<hr style="border:1px;border-top:1px solid black;">
			</p>
			
			
			
		</div>
		<div id="left-bottom">
			<img src="<%=request.getContextPath()%>/images/logo1.png">
			<p>当前登录用户</p>
		</div>
	</div>
</body>
</html>