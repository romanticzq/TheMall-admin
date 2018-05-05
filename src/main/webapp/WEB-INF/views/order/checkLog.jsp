<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户新增</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/plugins/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">

<link href="<%=request.getContextPath()%>/res/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <script src="<%=request.getContextPath()%>/res/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/res/jqPaginator.min.js" type="text/javascript"></script>
    <link href="<%=request.getContextPath()%>/res/myPage.css" rel="stylesheet" type="text/css" />
    <script src="<%=request.getContextPath()%>/res/myPage.js" type="text/javascript"></script>
</head>
<style>
    table,table tr th, table tr td { border:1px solid #ADADAD; }
    td {height:30px;}
</style>
<body onload="log()">
	<div id="center-add">

		<div id="content-add" style="margin-left:20px;">
			<div id="right-add" >
				<b>首页 > 订单管理 > 订单列表 > 物流详情</b><p></p>
				<form action="#" onsubmit="return order_delivery()" method="post">
					<h3>物流详情</h3>
					<div id="right-add-center">
						<div id="right-add-center-left">
							
							<p>快递公司：${orders.express.companyName }</p>
							<p>快递单号：${orders.deliveryNo } </p>
							<p>物流状态：<span id="span1"></span>
								<table>
									<c:forEach var="i" items="${tra}">
										<tr><td>${i.AcceptTime}</td><td>${i.AcceptStation}</td></tr>
									</c:forEach>
								</table>
							</p>
						</div>
					</div>
				</form>	
			</div>
		</div>
	</div>
</body>
</html>