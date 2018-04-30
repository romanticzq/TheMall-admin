<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="<%=request.getContextPath()%>/plugins/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
</head>
<script type="text/javascript">
	function login(){
		var name=$("#username").val();
		var password=$("#password").val();
		var flag=false;
		$.ajax({
			url:"adminLogin", //发送请求的地址
			type:"post", //请求方式 ("POST" 或 "GET")
			data:{name:name,password:password},  //发送到服务器的数据1
			dataType:"json", //预期返回的数据类型
			success:function(json){ //请求成功后的回调函数。
				if(json.success){
					alert("登录成功！");
					window.location.href="index";
				}else{
					alert("用户名或者密码错误！");
				}
			}
		});
		return flag;
	}
</script>
<body>
	<div class="div1">
		<div class="div2"><img src="images/login2.jpg"></div>
		<div class="div3">
			<form action="index"  method="post" onsubmit="return login()">
				<div class="div4">
					<h2 align="center" id="h2">孕妈妈商城后台管理系统</h2>
					<hr width="300">
				</div>
				<div class="div5">
					<p>用户名：<input type="text" name="name" id="username" placeholder="请输入您的用户名！" required></p>
					<p>密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" id="password" placeholder="请输入您的登录密码！" required></p>
					<p></p>
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