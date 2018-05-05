<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>孕妈妈商城后台管理系统</title>
<link href="<%=request.getContextPath()%>/css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/plugins/jquery-1.8.3.min.js"></script>
</head>
<script type="text/javascript">
	function login(){
		var name=$("#username").val();
		var password=$("#password").val();
		var val=$("#VerificationCode").val();
		var flag=false;
		$.ajax({
			url:"adminLogin", //发送请求的地址
			type:"post", //请求方式 ("POST" 或 "GET")
			data:{name:name,password:password,val:val},  //发送到服务器的数据1
			dataType:"json", //预期返回的数据类型
			success:function(json){ //请求成功后的回调函数。
				if(json.msg){
					alert(json.msg);
				}else{
					if(json.success){
						window.location.href="index";
					}else{
						alert("用户名或者密码错误！");
					}
				}
			}
		});
		return flag;
	}
</script>
<body>
	<div class="login_box">
      <div class="login_l_img"><img src="<%=request.getContextPath()%>/images/login-img.png" /></div>
      <div class="login">
          <div class="login_logo"><a href="#"><img src="<%=request.getContextPath()%>/images/login_logo.png" /></a></div>
          <div class="login_name">
               <p>孕妈妈商城后台管理系统</p>
          </div>
          <form method="post" onsubmit="return login()">
              <input name="username" type="text" id="username" placeholder="用户名" required>
              <input name="password" type="password" id="password" placeholder="密码" required >
              <input name="username" type="text" id="VerificationCode" placeholder="验证码" required style="width:70%">
              <img id="randCodeImage" alt="验证码"  src="ValidateCode" width="85" height="40" onclick="this.src='ValidateCode?'+Math.random();" style="padding-top:10px;"/>
              <input value="登录" style="width:100%;" type="submit">
              <input value="重置" style="width:100%;" type="reset" >
          </form>
      </div>
</div>
</body>
</html>