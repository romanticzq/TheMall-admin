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
    	
    	$("select:first option").removeAttr("selected");
    	var bigTypeName=$("#bigTypeName").val();
        $("select:first option:[value="+bigTypeName+"]").attr("selected","selected");
        
        var bigTypeName=$("#bigTypeName").val();
        if(bigTypeName!=null&&bigTypeName!=""){
        	$.ajax({
    			url:"productType_List_bybigtype", //发送请求的地址
    			type:"post", //请求方式 ("POST" 或 "GET")
    			async:false,
    			data:{typeName:bigTypeName},  //发送到服务器的数据1
    			dataType:"json", //预期返回的数据类型
    			contentType: "application/x-www-form-urlencoded; charset=utf-8",//解决编码问题
    			scriptCharset: 'utf-8',
    			success:function(json){ //请求成功后的回调函数。
    				var list=json.productTypeList;
    				$('select .op').remove();
    				$.each(list,function(n,item){
    					 var data='<option class="op" value="'+ item. typeName +'">'+ item. typeName +'</option>';
    					    $('select:last').append(data); 
    				 })
    			}
    		});
        }
        
        var typeName=$("#typeName").val();
        $("select:last option:[value="+typeName+"]").attr("selected","selected");
    })
    
        function loadData(num) {
        	
        	var numb=$("#pageList").val();
        	$("#PageCount").val(numb);
        }
        
		function selectPage(index) {
			var typeName=$("#typeName").val();
			var productName=$("#productName").val();
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
				url:"product_list_page_plug", //发送请求的地址
				type:"post", //请求方式 ("POST" 或 "GET")
				data:{typeName:typeName,productName:productName,index:index},  //发送到服务器的数据1
				dataType:"json", //预期返回的数据类型
				contentType: "application/x-www-form-urlencoded; charset=utf-8",//解决编码问题
				scriptCharset: 'utf-8',
				success:function(json){ //请求成功后的回调函数。
				 var list=json.productList;
				 var pageData=[];  
				 $('table .tr1').html("");
				 $.each(list,function(n,item){
					 var data='<tr class="tr1">'+  
					    '<td>'+item.productName+'</td>'+  
					    '<td>'+item.number+'</td>'+  
					    '<td>'+item.price+'</td>'+  
					    '<td>'+item.descr+'</td>'+  
					    '<td>'+item.smallType.typeName+'</td>'+ 
					    '<td>'+item.smallType.bigType.typeName+'</td>'+  
					    '<td>'+format(item.createDate)+'</td>'+  
					    '<td>'+format(item.editDate)+'</td>'+ 
					    '<td><a href="product_to_update?id='+item.productId+'">【修改】</a>&nbsp;<a href="#" onclick="delete_product('+item.productId+')">【删除】</a></td></tr>'; 
					 $('table').append(data); 
				 })
				}
			});
        }
		
		function loadType() {
        	var typeName=$("select:first option:selected").val();
        	$.ajax({
				url:"productType_List_bybigtype", //发送请求的地址
				type:"post", //请求方式 ("POST" 或 "GET")
				data:{typeName:typeName},  //发送到服务器的数据1
				dataType:"json", //预期返回的数据类型
				contentType: "application/x-www-form-urlencoded; charset=utf-8",//解决编码问题
				scriptCharset: 'utf-8',
				success:function(json){ //请求成功后的回调函数。
					var list=json.productTypeList;
					$('select .op').remove();
					$.each(list,function(n,item){
						 var data='<option class="op" value="'+ item. typeName +'">'+ item. typeName +'</option>';
						    $('select:last').append(data); 
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
				<b>首页 > 商品管理 > 商品列表</b><p></p>	
				<div id="right_head">
					
					<form method="post" action="product_list">
						商品名称：<input type="text" name="productName" value="${productName}">
						顶级商品类型：
						<select name="bigTypeName" style="width:220px" onclick="loadType()">
							<option value="">所有</option>
							<c:forEach items="${bigTypeList }" var="temp">
								<option value="${temp.typeName }">${temp.typeName }</option>
							</c:forEach>
						</select>
						次级商品类型：
						<select name="typeName" style="width:220px">
							<option value="">所有</option>
						</select>
						<input type="submit" value="查询">
						<input type="reset" value="重置">
					</form>
					<button onclick="javascript:window.location.href='product_to_edit?id=0'" style="display:none">新增商品</button>
				</div>

				<div id="right_foot">
					<table border="1" cellspacing="0">
						<tr bgcolor="#EFF0EF">
							<td>商品名称</td>
							<td>数量</td>
							<td>单价</td>
							<td>描述</td>
							<td>商品类型</td>
							<td>顶级商品类型</td>
							<td>创建时间</td>
							<td>修改时间</td>
							<td style="text-align:center">操作</td>
						</tr>
						<c:forEach items="${productList}" var="temp" >
							<tr class="tr1">
								<td>${temp.productName }</td>
								<td>${temp.number }</td>
								<td>${temp.price }</td>
								<td>${temp.descr }</td>
								<td>${temp.smallType.typeName }</td>
								<td>${temp.smallType.bigType.typeName }</td>
								<td>
									<fmt:formatDate value="${temp.createDate }" pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
								<td>
									<fmt:formatDate value="${temp.editDate }" pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
								<td><a  href="product_to_update?id=${temp.productId}">【修改】</a>&nbsp;<a href="#" onclick="delete_product(${temp.productId})">【删除】</a></td>
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
							<input type="hidden" id="typeName" runat="server" value="${typeName}" />
							<input type="hidden" id="bigTypeName" runat="server" value="${bigTypeName}" />
							<input type="hidden" id="productName" runat="server" value="${productName}" />
						</div>
					</form>
					<label>当前页数:<span></span>，共:<span></span>页，<span></span>条记录</label>
				</div>
			</div>
		</div>
	</div>
</body>
</html>