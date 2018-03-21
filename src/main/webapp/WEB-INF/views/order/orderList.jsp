<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户查询</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/plugins/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div id="center">
		<jsp:include page="../common/left.jsp" />

		<div id="content">
			<div id="right">
				<div id="right_head">
					
					<form method="post" action="order_list">
						订单状态：
						<select name="status" style="width:220px">
							<option value="a">所有</option>
							<option value="w">未发货</option>
							<option value="f">已发货</option>
							<option value="q">已签收</option>
						</select>
						用户名称：<input type="text" name="userName">
						<input type="submit" value="查询">
						<input type="reset" value="重置">
					</form>
				</div>

				<div id="right_foot">
					<table border="1" cellspacing="0">
						<tr bgcolor="#EFF0EF">
							<td>订单状态</td>
							<td>总价</td>
							<td>数量</td>
							<td>留言</td>
							<td>用户</td>
							<td>地址</td>
							<td>创建时间</td>
							<td>修改时间</td>
							<td style="text-align:center">操作</td>
						</tr>
						<c:forEach items="${orderList}" var="temp" >
							<tr class="tr1">
								<td>
								    <c:if test="${temp.status == 1 }">未发货</c:if>  
									<c:if test="${temp.status == 2 }">已发货</c:if>  
									<c:if test="${temp.status == 3 }">已签收</c:if> 
								</td>
								<td>${temp.price }</td>
								<td>${temp.number }</td>
								<td>${temp.message }</td>
								<td>${temp.user.userName }</td>
								<td>${temp.user.address }</td>
								<td>${temp.createDate }</td>
								<td>${temp.editDate }</td>
								<td>
									<a href="order_send?id=${temp.id}" onclick="return judge()">【发货】</a>
									<a href="order_?id=${temp.id}">【详情】</a>
								</td>
							</tr>
						</c:forEach>
						
					</table>
				</div>
			</div>
			<footer>Copyright2017轻实训版权所有</footer>
		</div>
	</div>
</body>
</html>