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
    
</style>
<body>
	<div id="center-add">

		<div id="content-add">
			<div id="right-add" style="margin-left:20px;">
				<b>首页 > 订单管理 > 订单列表 > 订单详情</b><p></p>
				<form action="#" onsubmit="return order_delivery()" method="post">
					<h3>订单详情</h3>
					<div id="right-add-center">
						<div id="right-add-center-left">
							商品详情：
							<table style="border: 1px solid #ADADAD; border-color: #ADADAD;margin:5px 0px 20px 0px;" id="table1" class="table1">
								<tr>
									<th width="70px" height="30px">商品名称</th>
									<th width="30px" height="30px">单价</th>
									<th width="30px" height="30px">数量</th>
									<th width="30px" height="30px">总价</th>
									<th width="150px" height="30px">买方留言</th>
								</tr>
								<tr>
									<td height="30px">${orders.commodity.productName }</td>
									<td height="30px">${orders.commodity.price }</td>
									<td height="30px">${orders.count }</td>
									<td height="30px">${orders.total_fee }</td>
									<td height="30px">${orders.message }</td>
								</tr>
							</table>
							收货信息：
							<table style="border: 1px solid #ADADAD;text-align:center;margin-top:5px;">
								<tr>
									<th width="30px" height="30px">收货人</th>
									<td width="150px" height="30px">${orders.address.receiverName }</td>
								</tr>
								<tr>
									<th width="30px" height="30px">收货电话</th>
									<td width="150px" height="30px">${orders.address.telephone }</td>
								</tr>
								<tr>
									<th width="30px" height="30px">收货地址</th>
									<td width="150px" height="30px">${orders.address.address }</td>
								</tr>
							</table>
						</div>
					</div>
				</form>	
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
</script>
</html>