<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户查询</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/plugins/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">

<!-- 分页插件 -->
<link href="<%=request.getContextPath()%>/res/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <script src="<%=request.getContextPath()%>/res/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/res/jqPaginator.min.js" type="text/javascript"></script>
    <link href="<%=request.getContextPath()%>/res/myPage.css" rel="stylesheet" type="text/css" />
    <script src="<%=request.getContextPath()%>/res/myPage.js" type="text/javascript"></script>
    <script type="text/javascript">
    
	    $(function () {
	    	$("select option").removeAttr("selected");
	    	var sex=$("#sex").val();
	    	$("select:first option:[value="+sex+"]").attr("selected","selected");
	    	
	    	
	    	var status=$("#status").val();
	    	$("select:last option:[value="+status+"]").attr("selected","selected");
	    })
	    
        function loadData(num) {
        	
        	var numb=$("#pageList").val();
        	$("#PageCount").val(numb);
        }
        
		function selectPage(index) {
			var userName=$("#userName").val();
			var status=$("#status").val();
			var sex=$("#sex").val();
			if(index==100){
				index=pageNo-1;
			}
			
			if(index==101){
				if(pageNo<($("span:eq(1)").html())){
					index=pageNo+1;
				}else{
					index=pageNo;
				}
			}
			$.ajax({
				url:"user_list_page_plug", //发送请求的地址
				type:"post", //请求方式 ("POST" 或 "GET")
				data:{userName:userName,status:status,sex:sex,index:index},  //发送到服务器的数据1
				dataType:"json", //预期返回的数据类型
				contentType: "application/x-www-form-urlencoded; charset=utf-8",//解决编码问题
				scriptCharset: 'utf-8',
				success:function(json){ //请求成功后的回调函数。
				 var list=json.userList;
				 var pageData=[];  
				 $('table .tr1').html("");
				 $.each(list,function(n,item){
					 if(item.status=="冻结"){
						 var str="【解冻】";
					 }else{
						 var str="【冻结】";
					 }
					 var data='<tr class="tr1">'+  
					    '<td>'+item.userName+'</td>'+
					    '<td>'+item.nickname+'</td>'+
					    '<td>'+item.gender+'</td>'+  
					    '<td>'+item.email+'</td>'+ 
					    '<td>'+item.phone+'</td>'+ 
					    '<td>'+item.status+'</td>'+  
					    '<td>'+item.realName+'</td>'+  
					    '<td>'+format(item.createDate)+'</td>'+  
					    '<td>'+format(item.editDate)+'</td>'+  
					    '<td><a href="#" onclick="judge('+item.userId+')">'+str+'</a>&nbsp;'+
					    '<a href="#" onclick="delete_user('+item.userId+')">【删除】</a></td></tr>'; 
					 $('table').append(data); 
				 })
				}
			});
        }
		
    </script>
    
</head>
<body>
	<div id="center">

		<div id="content">
			
			<div id="right" style="margin-left:20px;">
				<b>首页 > 用户管理 > 用户列表</b><p></p>	
				<div id="right_head">
				
					<form method="post" action="user_list">
						用户名称：<input type="text" name="userName" value="${userName}" id="userName">
						性别：
						<select name="sex" style="width:220px">
							<option value="">所有</option>
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
						状态：
						<select name="status" style="width:220px">
							<option value="">所有</option>
							<option value="正常">正常</option>
							<option value="冻结">冻结</option>
						</select>
						<input type="submit" value="查询">
						<input type="reset" value="重置">
					</form>
				</div>

				<div id="right_foot">
					<table border="1" cellspacing="0">
						<tr bgcolor="#EFF0EF">
							<td>用户名</td>
							<td>昵称</td>
							<td>性别</td>
							<td>邮箱</td>
							<td>电话</td>
							<td>状态</td>
							<td>真实姓名</td>
							<td>创建时间</td>
							<td>修改时间</td>
							<td style="text-align:center">操作</td>
						</tr>
						<c:forEach items="${userList}" var="temp" >
							<tr class="tr1">
								<td>${temp.userName }</td>
								<td>${temp.nickname }</td>
								<td>${temp.gender }</td>
								<td>${temp.email }</td>
								<td>${temp.phone }</td>
								<td>${temp.status }</td>
								<td>${temp.realName }</td>
								<td>
									<fmt:formatDate value="${temp.createDate }" pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
								<td>
									<fmt:formatDate value="${temp.editDate }" pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
								<td>
									<a href="#" onclick="judge(${temp.userId })" >
										<c:if test="${temp.status == '正常' }">【冻结】</c:if>  
										<c:if test="${temp.status == '冻结' }">【解冻】</c:if>  
									</a>&nbsp;
									<a href="#" onclick="delete_user(${temp.userId })">【删除】</a>
								</td>
							</tr>
						</c:forEach>
						
					</table>
					<form id="form1" runat="server">
						<div></div>
						<div>
							<ul class="pagination" id="pagination">
							</ul>
							<input type="hidden" id="PageCount" runat="server" /> <input
								type="hidden" id="PageSize" runat="server" value="5" /> <input
								type="hidden" id="countindex" runat="server" value="10" />
							<!--设置最多显示的页码数 可以手动设置 默认为5-->
							<input type="hidden" id="visiblePages" runat="server" value="5" />
							<input type="hidden" id="pageList" runat="server" value="${num}" />
							<input type="hidden" id="status" runat="server" value="${sta}" />
							<input type="hidden" id="sex" runat="server" value="${se}" />
						</div>
					</form>
					<label>当前页数:<span></span>，共:<span></span>页，<span></span>条记录</label>
				</div>
			</div>
		</div>
	</div>
</body>
</html>