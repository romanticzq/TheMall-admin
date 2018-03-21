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
					
					<form method="post" action="product_list">
						商品名称：<input type="text" name="productName">
						商品类型名称：
						<select name="typeName" style="width:220px">
							<option value="">所有</option>
							<c:forEach items="${typeList }" var="temp">
								<option value="${temp.typeName }">${temp.typeName }</option>
							</c:forEach>
						</select>
						<input type="submit" value="查询">
						<input type="reset" value="重置">
					</form>
					<button onclick="product_to_edit()">新增商品</button>
				</div>

				<div id="right_foot">
					<table border="1" cellspacing="0">
						<tr bgcolor="#EFF0EF">
							<td>商品名称</td>
							<td>数量</td>
							<td>单价</td>
							<td>描述</td>
							<td>商品类型</td>
							<td>创建时间</td>
							<td>修改时间</td>
							<td style="text-align:center">操作</td>
						</tr>
						<c:forEach items="${productList}" var="temp" >
							<tr class="tr1">
								<td>${temp.productName }</td>
								<td>${temp.number }</td>
								<td>${temp.price }</td>
								<td>${temp.description }</td>
								<td>${temp.type.typeName }</td>
								<td>${temp.createDate }</td>
								<td>${temp.editDate }</td>
								<td><a  onclick="return product_to_edit(${temp.id})">【修改】</a>&nbsp;<a href="#" onclick="return delete_product(${temp.id})">【删除】</a></td>
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