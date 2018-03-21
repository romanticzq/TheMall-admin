<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="div1">
		<div class="div2"><img src="images/login.png"></div>
		<div class="div3">
			<form action="springmvc/admin_login"  method="post">
				<div class="div4">
					<img class="img1" src="images/login1.png">
					<h2 align="center" id="h2">用户管理系统登录</h2>
					<hr width="300">
				</div>
				<div class="div5">
					<p>用户名：<input type="text" name="name" id="username" placeholder="请输入您的用户名！" required></p>
					<p>密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" id="password" placeholder="请输入您的登录密码！" required></p>
					<p><label><input type="checkbox" name="checkbox">记住密码</label></p>
					<p>
						<input type="submit"  class="login" value="登录">
						<input type="reset" class="reset" value="重置">
					</p>
				</div>
			</form>
		</div>
	</div>
</body>
</html>