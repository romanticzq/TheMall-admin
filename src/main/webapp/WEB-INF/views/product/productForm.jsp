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
<body>
	<div id="center-add">

		<div id="content-add">
			<div id="right-add" style="margin-left:20px;">
				<b>首页 > 商品管理 > 新增商品</b><p></p>	
				<form action="#" onsubmit="return product_edit()" method="post" id="newsForm">
					<div id="right-add-center" style="">
						<div id="right-add-center-left">
							<input type="hidden" value="${product.productId}"  name="id" id="id">
							<p>商品类型：
								<select name="type.typeName" id="typeName">
									<c:forEach items="${type }" var="temp">
										<option value="${temp.typeName }">${temp.typeName }</option>
									</c:forEach>
								</select>
							</p>
							<p>商品名称：<span style="margin-left:5px;"></span><input type="text" placeholder="请输入商品名称！" class="input" required name="productName" id="productName" value="${product.productName }"></p>
							<p>数<span style="margin-left:28px;"></span>量：<span style="margin-left:4px;"></span><input type="text" placeholder="请输入商品数量！" class="input" required name="number" id="number" value="${product.number }"></p>
							<p>单<span style="margin-left:28px;"></span>价：<span style="margin-left:4px;"></span><input type="text" placeholder="请输入商品单价！" class="input" required name="price" id="price" value="${product.price }"></p>
							<p>描<span style="margin-left:28px;"></span>述：<span style="margin-left:4px;"></span><input type="text" placeholder="请输入商品描述！" class="input" required name="description" id="description" value="${product.descr }"></p>
							
							<p>商品图片：<input type="file"  class="input" onchange="preview(this)" name="imgUrl" id="imgUrl" value="${product.imgUrl}" style="display:none"></p>
							<img src="${product.imgUrl}" onclick="fileSelect()" id="img" style="margin-left:80px" onerror='this.src="<%=request.getContextPath()%>/images/uploadimage.jpg"'>
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
		</div>
	</div>
</body>
</html>