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

<link href="<%=request.getContextPath()%>/res/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <script src="<%=request.getContextPath()%>/res/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/res/jqPaginator.min.js" type="text/javascript"></script>
    <link href="<%=request.getContextPath()%>/res/myPage.css" rel="stylesheet" type="text/css" />
    <script src="<%=request.getContextPath()%>/res/myPage.js" type="text/javascript"></script>
    <script type="text/javascript">
    
	    $(function () {
	    	$("select option").removeAttr("selected");
	    	var sta=$("#status").val();
	    	$("select option:[value="+sta+"]").attr("selected","selected");
	        
	    })
	    
        function loadData(num) {
        	
        	var numb=$("#pageList").val();
        	$("#PageCount").val(numb);
        }
        
		function selectPage(index) {
			var userName=$("#userName").val();
			var status=$("#status").val();
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
				url:"order_list_page_plug", //发送请求的地址
				type:"post", //请求方式 ("POST" 或 "GET")
				data:{userName:userName,status:status,index:index},  //发送到服务器的数据1
				dataType:"json", //预期返回的数据类型
				contentType: "application/x-www-form-urlencoded; charset=utf-8",//解决编码问题
				scriptCharset: 'utf-8',
				success:function(json){ //请求成功后的回调函数。
				 var list=json.orderList;
				 var pageData=[];  
				 $('table .tr1').html("");
				 $.each(list,function(n,item){
					 if(item.orderStatus=="待发货"){
						 var str="【发货】";
					 }else if(item.orderStatus=="待收货"){
						 var str="【查看物流】";
					 }
					 var data='<tr class="tr1">'+  
					    '<td>'+item.orderStatus+'</td>'+
					    '<td>'+item.total_fee+'</td>'+  
					    '<td>'+item.count+'</td>'+  
					    '<td>'+item.message+'</td>'+  
					    '<td>'+item.user.userName+'</td>'+  
					    '<td>'+item.logistics+'</td>'+  
					    '<td>'+format(item.createDate)+'</td>'+ 
					    '<td><a href="order_to_delivery?id='+item.id+'">'+str+'</a>&nbsp;'+
					    '<a href="order_?id='+item.id+'">【详情】</a></td></tr>'; 
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
				<b>首页 > 订单管理 > 订单列表</b><p></p>	
				<div id="right_head">
					
					<form method="post" action="order_list">
						订单状态：
						<select name="status" style="width:220px">
							<option value="" >所有</option>
							<option value="未付款" >未付款</option>
							<option value="未发货" >未发货</option>
							<option value="已发货" >已发货</option>
							<option value="已签收" >已签收</option>
						</select>
						用户名称：<input type="text" name="userName" id="userName" value="${userName}">
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
							<td>指定快递</td>
							<td>创建时间</td>
							<td style="text-align:center">操作</td>
						</tr>
						<c:forEach items="${orderList}" var="temp" >
							<tr class="tr1">
								<td>${temp.orderStatus }</td>
								<td>${temp.total_fee }</td>
								<td>${temp.count }</td>
								<td>${temp.message }</td>
								<td>${temp.user.userName }</td>
								<td>${temp.logistics }</td>
								<td>${temp.createDate }</td>
								<td>
									<c:if test="${temp.orderStatus == '待发货' }">
										<a href="order_to_delivery?id=${temp.id}" >【发货】</a>
									</c:if>  
									<c:if test="${temp.orderStatus == '待收货' }">
										<a href="checkLog?id=${temp.id}" >【查看物流】</a>
									</c:if>
									&nbsp;
									<a href="order_to_detail?id=${temp.id}" >【订单详情】</a>
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
						</div>
					</form>
					<label>当前页数:<span></span>，共:<span></span>页，<span></span>条记录</label>
				</div>
			</div>
		</div>
	</div>
</body>
</html>