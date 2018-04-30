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
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div id="center-add">
		<jsp:include page="../common/left.jsp" />

		<div id="content-add">
			<div id="right-add">
				<form action="#" onsubmit="return product_edit()" method="post" id="newsForm">
					<h3>新增&修改商品信息</h3>
					<div id="right-add-center">
						<div id="right-add-center-left">
							<input type="hidden" value="${product.id}"  name="id" id="id">
							<p>商品名称：<input type="text" placeholder="请输入商品名称！" class="input" required name="productName" id="productName" value="${product.productName }"></p>
							<p>数量：<input type="text" placeholder="请输入商品数量！" class="input" required name="number" id="number" value="${product.number }"></p>
							<p>单价：<input type="text" placeholder="请输入商品单价！" class="input" required name="price" id="price" value="${product.price }"></p>
							<p>描述：<input type="text" placeholder="请输入商品描述！" class="input" required name="description" id="description" value="${product.description }"></p>
							<p>商品类型：
								<select name="type.typeName" id="typeName">
									<c:forEach items="${type }" var="temp">
										<option value="${temp.typeName }">${temp.typeName }</option>
									</c:forEach>
								</select>
							</p>
							<p><input type="file"  class="input" onchange="preview(this)" name="imgUrl" id="imgUrl"></p>
							<img src="<%=request.getContextPath()%>${product.imgUrl }">
						</div>
						
						<div id="right-add-center-right">
							<p><input type="file"  class="input" onchange="preview(this)" name="imgUrl" id="imgUrl"></p>
							<img src="<%=request.getContextPath()%>${product.imgUrl }">
							
						</div>
					</div>
					<hr>
					<div id="div_button">
						<input id="sub" type="submit" value="保存">
						<input id="res" type="reset" value="重置">
						<input id="but" type="button" value="返回" 
						onclick="back_productList()">
					</div>
				</form>	
			</div>
			<footer>Copyright2017轻实训版权所有</footer>
		</div>
	</div>
</body>
</html>