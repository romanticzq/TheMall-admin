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

<link href="<%=request.getContextPath()%>/res/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <script src="<%=request.getContextPath()%>/res/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="<%=request.getContextPath()%>/res/jqPaginator.min.js" type="text/javascript"></script>
    <link href="<%=request.getContextPath()%>/res/myPage.css" rel="stylesheet" type="text/css" />
    <script src="<%=request.getContextPath()%>/res/myPage.js" type="text/javascript"></script>
<script type="text/javascript">
    
		$(function () {
			$("select option").removeAttr("selected");
			var bigTypeName=$("#bigTypeName").val();
		    $("select option:[value="+bigTypeName+"]").attr("selected","selected");
		  
		})
    
        function loadData(num) {
        	
        	var numb=$("#pageList").val();
        	$("#PageCount").val(numb);
        }
        
		function selectPage(index) {
			var name=$("#typeName").val();
			var bigTypeName=$("#bigTypeName").val();
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
				url:"productType_list_page_plug", //发送请求的地址
				type:"post", //请求方式 ("POST" 或 "GET")
				data:{name:name,bigTypeName:bigTypeName,index:index},  //发送到服务器的数据1
				dataType:"json", //预期返回的数据类型
				contentType: "application/x-www-form-urlencoded; charset=utf-8",//解决编码问题
				scriptCharset: 'utf-8',
				success:function(json){ //请求成功后的回调函数。
				 var list=json.productTypeList;
				 var pageData=[];  
				 $('table .tr1').html("");
				 $.each(list,function(n,item){
					 var data='<tr class="tr1">'+  
					    '<td>'+item.typeName+'</td>'+  
					    '<td>'+item.bigType.typeName+'</td>'+ 
					    '<td>'+item.createDate+'</td>'+  
					    '<td>'+item.editDate+'</td>'+  
					    '<td><a onclick="productType_to_edit('+item.id+')">【修改】</a>&nbsp;<a href="#" onclick="return delete_type('+item.id+')">【删除】</a></td></tr>'; 
					 $('table').append(data); 
				 })
				}
			});
        }
    </script>
</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<div id="center">
		<jsp:include page="../common/left.jsp" />

		<div id="content">
			<div id="right">
				<div id="right_head">
					
					<form method="post" action="productType_list">
						顶级商品类型：
						<select name="bigTypeName" style="width:220px">
							<option value="">所有</option>
							<c:forEach items="${bigTypeList }" var="temp">
								<option value="${temp.typeName }">${temp.typeName }</option>
							</c:forEach>
						</select>
						商品类型名称：<input type="text" name="typeName" id="typeName" value="${typeName }">
						<input type="submit" value="查询">
						<input type="reset" value="重置">
					</form>
					<button onclick="productType_to_edit()">新增商品类型</button>
				</div>

				<div id="right_foot">
					<table border="1" cellspacing="0">
						<tr bgcolor="#EFF0EF">
							<td>商品类型名称</td>
							<td>父级商品类型名称</td>
							<td>创建时间</td>
							<td>修改时间</td>
							<td style="text-align:center">操作</td>
						</tr>
						<c:forEach items="${productTypeList}" var="temp" >
							<tr class="tr1">
								<td>${temp.typeName }</td>
								<td>${temp.bigType.typeName }</td>
								<td>${temp.createDate }</td>
								<td>${temp.editDate }</td>
								<td><a onclick="productType_to_edit(${temp.id})">【修改】</a>&nbsp;<a onclick="return delete_type(${temp.id })">【删除】</a></td>
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
							<input type="hidden" id="bigTypeName" runat="server" value="${bigTypeName}" />
						</div>
					</form>
					<label>当前页数:<span></span>，共:<span></span>页，<span></span>条记录</label>
				</div>
			</div>
			<footer>Copyright2017轻实训版权所有</footer>
		</div>
	</div>
</body>
</html>