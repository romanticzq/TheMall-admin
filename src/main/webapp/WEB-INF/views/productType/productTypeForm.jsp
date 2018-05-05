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
				<b>首页 > 商品管理 > 新增商品类别</b><p></p>	
				<form action="#" onsubmit="return productType_edit()" method="post">
					<div id="right-add-center">
						<div id="right-add-center-left">
							<input type="hidden" value="${productType.id}"  name="id" id="id">
							<p>顶级商品类型：
								<select name="bigTypeName" id="bigTypeName">
									<c:forEach items="${bigType }" var="temp">
										<option value="${temp.typeName }">${temp.typeName }</option>
									</c:forEach>
								</select>
							</p>
							<p>商品类型名称：<input type="text" placeholder="请输入商品类型名称！" class="input" required name="typeName" value="${productType.typeName }" id="typeName"></p>
						</div>
					</div>
					<hr>
					<div id="div_button">
						<input id="sub" type="submit" value="保存">
						<input id="res" type="reset" value="重置">
						<input id="but" type="button" value="返回" 
						onclick="backType()">
					</div>
				</form>	
			</div>
		</div>
	</div>
</body>
</html>