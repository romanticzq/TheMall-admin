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
				
					<form method="post" action="user_list">
						用户名称：<input type="text" name="userName">
						性别：
						<select name="sex" style="width:220px">
							<option value="a">所有</option>
							<option value="m">男</option>
							<option value="f">女</option>
						</select>
						状态：
						<select name="status" style="width:220px">
							<option value="a">所有</option>
							<option value="z">正常</option>
							<option value="d">冻结</option>
						</select>
						<input type="submit" value="查询">
						<input type="reset" value="重置">
					</form>
				</div>

				<div id="right_foot">
					<table border="1" cellspacing="0">
						<tr bgcolor="#EFF0EF">
							<td>用户名称</td>
							<td>性别</td>
							<td>邮箱</td>
							<td>状态</td>
							<td>真实姓名</td>
							<td>身份证号</td>
							<td>收货地址</td>
							<td>创建时间</td>
							<td>修改时间</td>
							<td style="text-align:center">操作</td>
						</tr>
						<c:forEach items="${userList}" var="temp" >
							<tr class="tr1">
								<td>${temp.userName }</td>
								<td>
									<c:if test="${temp.sex == 1 }">男</c:if>  
									<c:if test="${temp.sex == 2 }">女</c:if>  
								</td>
								<td>${temp.email }</td>
								<td>
									<c:if test="${temp.status == 1 }">正常</c:if>  
									<c:if test="${temp.status == 2 }">冻结</c:if>  
								</td>
								<td>${temp.realName }</td>
								<td>${temp.personId }</td>
								<td>${temp.address }</td>
								<td>${temp.createDate }</td>
								<td>${temp.editDate }</td>
								<td><a href="#" onclick="return judge(${temp.id })">【修改状态】</a>&nbsp;<a href="#" onclick="return delete_user(${temp.id })">【删除】</a></td>
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