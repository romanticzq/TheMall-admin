
//格式化时间
function format(date) {
	var time = new Date(date);
	var year = time.getFullYear();
	var month = time.getMonth() + 1;
	if (month < 10) {
		month = "0" + month;
	}
	var date = time.getDate();
	if (date < 10) {
		date = "0" + date;
	}
	var hours = time.getHours();
	if (hours < 10) {
		hours = "0" + hours;
	}
	var min = time.getMinutes();
	if (min < 10) {
		min = "0" + min;
	}
	var sec = time.getSeconds();
	if (sec < 10) {
		sec = "0" + sec;
	}
	var d = year + "-" + month + "-" + date + " " + hours + ":" + min + ":"
			+ sec;
	return d;
}

/**
 * 商品类型js
 */
// 去新增
function productType_to_edit() {
		$.ajax({
			url:"productType_to_edit", // 发送请求的地址
			type:"get", // 请求方式 ("POST" 或 "GET")
			data:{"id":0},
			success:function(data){ // 请求成功后的回调函数。
				window.location.href=data;// 需要跳转的地址
			}
		})
	}

// 去修改
function productType_to_edit(id) {
	$.ajax({
		url:"productType_to_edit", //发送请求的地址
		type:"post", //请求方式 ("POST" 或 "GET")
		data:{"id":id},  //发送到服务器的数据1
		success:function(data){ //请求成功后的回调函数。
			$("html").html(data);
		}
	})
}

//实现新增或修改
function productType_edit() {
	var id=$("#id").val();
	if(id==""||id==null){
		id=0;
	}
	var bigTypeName=$("#bigTypeName").val();
	var typeName=$("#typeName").val();
	$.ajax({
		url:"productType_edit", //发送请求的地址
		type:"post", //请求方式 ("POST" 或 "GET")
		data:{"id":id,"bigTypeName":bigTypeName,"typeName":typeName},  //发送到服务器的数据1
		dataType:"html",
		success:function(data){ //请求成功后的回调函数。
			$("#typeName").val("");
			$("select option").removeAttr("selected");
			$("select option:eq(0)").attr("selected","selected");
			alert("添加成功,请到商品列表查看");
		}
	})
	return false;
}
////实现新增或修改
//function productType_edit() {
//	$.ajax({
//		url:"productType_edit", //发送请求的地址
//		type:"post", //请求方式 ("POST" 或 "GET")
//		data:$("form").serialize(),  //发送到服务器的数据1
//		dataType:"html",
//		success:function(data){ //请求成功后的回调函数。
//			$("html").html(data);
//			window.location.reload();
//		}
//	})
//	return false;
//}
//返回方法
function backType() {
//	$.ajax({
//		url:"productType_list", //发送请求的地址
//		type:"post", //请求方式 ("POST" 或 "GET")
//		data:{},  //发送到服务器的数据1
//		dataType:"html",
//		success:function(data){ //请求成功后的回调函数。
//			$("html").html(data);
//			window.location.reload();
//		}
//	})
	window.location.href="productType_list";
}

//询问是否删除
function delete_type(id) {
	var con;
	con=confirm("确定删除该商品类型?");
	if(con){
		productType_delete(id);
		return true;
	}	
	return false;
}

//删除方法
function productType_delete(id) {
	$.ajax({
		url:"productType_delete", //发送请求的地址
		type:"post", //请求方式 ("POST" 或 "GET")
		data:{"id":id},  //发送到服务器的数据1
		dataType:"json",
		success:function(data){ //请求成功后的回调函数。
			if(data.msg=="success"){
				alert("删除成功");
				window.location.href="productType_list";
			}else{
				alert("该商品类型下面存在商品，请先删除该商品类型下的商品！");
			}
		}
	})
}

/**
 * 用户js
 */

//修改方法
function judge(id) {
	var con;
	con=confirm("确定修改该用户的状态?");
	if(con){
		user_edit(id);
		return true;
	}
	return false;
}

function user_edit(id) {
	$.ajax({
		url:"user_edit", //发送请求的地址
		type:"post", //请求方式 ("POST" 或 "GET")
		data:{"id":id},  //发送到服务器的数据1
		success:function(data){ //请求成功后的回调函数。
			alert("修改成功");
			window.location.href="user_list";
		}
	})
}

//删除
function delete_user(id){
	var con;
	con=confirm("确定删除该用户?");
	if(con){
		user_delete(id);
		return true;
	}	
	return false;
}

function user_delete(id){
	$.ajax({
		url:"user_delete", //发送请求的地址
		type:"post", //请求方式 ("POST" 或 "GET")
		data:{"id":id},  //发送到服务器的数据1
		success:function(data){ //请求成功后的回调函数。
			alert("删除成功");
			window.location.href="user_list";
		}
	})
}

/**
 * 商品js
 */
//去新增
function product_to_edit(){
	$.ajax({
		url:"product_to_edit", //发送请求的地址
		type:"post", //请求方式 ("POST" 或 "GET")
		success:function(data){ //请求成功后的回调函数。
			$("html").html(data);
		}
	})
}

//去修改
function product_to_edit(id){
	$.ajax({
		url:"product_to_edit", //发送请求的地址
		type:"post", //请求方式 ("POST" 或 "GET")
		data:{"productId":id},  //发送到服务器的数据1
		success:function(data){ //请求成功后的回调函数。
			$("html").html(data);
		}
	})
}

//新增方法
function product_edit() {
	var formData = new FormData();
	var id=$("#id").val();
	if(id==''||id==null){
		id=0;
	}
	 formData.append("productId", id);
	 formData.append("productName", $("#productName").val());
	 formData.append("number", $("#number").val());
	 formData.append("price", $("#price").val());
	 formData.append("descr", $("#description").val());
	 formData.append("typeName", $("#typeName").val());
	 formData.append("file", $("#imgUrl")[0].files[0]);
	$.ajax({
		url:"product_edit", //发送请求的地址
		type:"post", //请求方式 ("POST" 或 "GET")
		data:formData,  //发送到服务器的数据1
		contentType: false,
        processData: false,
		success:function(data){ //请求成功后的回调函数。
			$("#productName").val("");
			$("#number").val("");
			$("#price").val("");
			$("#description").val("");
			$("#imgUrl").val("");
			$("#img").attr("src","");
			$("select option").removeAttr("selected");
			$("select option:eq(0)").attr("selected","selected");
			alert("新增商品成功，请到商品列表查看");
		}
	})
	return false;
}

//修改方法
function product_update() {
	var formData = new FormData();
	var id=$("#id").val();
	if(id==''||id==null){
		id=0;
	}
	 formData.append("productId", id);
	 formData.append("productName", $("#productName").val());
	 formData.append("number", $("#number").val());
	 formData.append("price", $("#price").val());
	 formData.append("descr", $("#description").val());
	 formData.append("typeName", $("#typeName").val());
	 formData.append("file", $("#imgUrl")[0].files[0]);
	 formData.append("img", $("#imgUrl").val());
	$.ajax({
		url:"product_edit", //发送请求的地址
		type:"post", //请求方式 ("POST" 或 "GET")
		data:formData,  //发送到服务器的数据1
		contentType: false,
        processData: false,
		success:function(data){ //请求成功后的回调函数。
			alert("修改商品成功");
			window.location.href="product_list";
		}
	})
	return false;
}

//返回方法
function back_productList() {
//	$.ajax({
//		url:"product_list", //发送请求的地址
//		type:"post", //请求方式 ("POST" 或 "GET")
//		data:{},  //发送到服务器的数据1
//		dataType:"html",
//		success:function(data){ //请求成功后的回调函数。
//			$("html").html(data);
//			window.location.reload();
//		}
//	})
	window.location.href="product_list";
}

//删除方法
function delete_product(id) {
	var con;
	con=confirm("确定删除该商品?");
	if(con){
		product_delete(id);
		return true;
	}	
	return false;
}

function product_delete(id) {
	$.ajax({
		url:"product_delete", //发送请求的地址
		type:"post", //请求方式 ("POST" 或 "GET")
		data:{"id":id},  //发送到服务器的数据1
		success:function(data){ //请求成功后的回调函数。
			alert("删除商品成功");
			window.location.href="product_list";
		}
	})
}
//
function preview(file) {
	  var prev = $("#img");
	  if (file.files && file.files[0]) {
	   var reader = new FileReader();
	   reader.onload = function (evt) {
	   prev.attr("src",evt.target.result);   
	   }
	   reader.readAsDataURL(file.files[0]);
	  }
	 }

function fileSelect() {
    $("#imgUrl").click(); 
}
/**
 * 订单js
 */

//修改方法
function judge_order(id,status) {
	if(status==1){
		var con;
		con=confirm("确定发货该订单?");
		if(con){
			order_edit(id);
			window.location.reload();
			return true;
		}
	}else if(status==2){
		alert("该订单已发货！")
	}else{
		alert("该订单已签收！")
	}
	
	return false;
}

function order_edit(id) {
	alert("发货成功！");
	$.ajax({
		url:"order_send", //发送请求的地址
		type:"post", //请求方式 ("POST" 或 "GET")
		data:{"id":id},  //发送到服务器的数据1
		success:function(data){ //请求成功后的回调函数。
			
			$("html").html(data);
		}
	})
}

////删除方法
//function delete_order(id) {
//	var con;
//	con=confirm("确定删除该用户?");
//	if(con){
//		user_delete(id);
//		return true;
//	}	
//	return false;
//}
//
//function user_delete(id) {
//	$.ajax({
//		url:"user_delete", //发送请求的地址
//		type:"post", //请求方式 ("POST" 或 "GET")
//		data:{"id":id},  //发送到服务器的数据1
//		success:function(data){ //请求成功后的回调函数。
//			$("html").html(data);
//			window.location.reload();
//		}
//	})
//}

//去发货
function order_to_delivery(id) {
		$.ajax({
			url:"order_to_delivery", //发送请求的地址
			type:"post", //请求方式 ("POST" 或 "GET")
			data:{"id":id},  //发送到服务器的数据1
			success:function(data){ //请求成功后的回调函数。
				$("html").html(data);
			}
		})
	}

//发货
function order_delivery() {
		var id=$("#id").val();
		var com=$("#express").val();
		var deli=$("#deliveryNo").val();
		$.ajax({
			url:"order_delivery", //发送请求的地址
			type:"post", //请求方式 ("POST" 或 "GET")
			data:{"id":id,"companyName":com,"deliveryNo":deli},  //发送到服务器的数据1
			success:function(data){ //请求成功后的回调函数。
				$("html").html(data);
				window.location.reload();
			}
		})
		return false;
	}

//查看详情
function order_to_detail(id) {
		$.ajax({
			url:"order_to_detail", //发送请求的地址
			type:"post", //请求方式 ("POST" 或 "GET")
			data:{"id":id},  //发送到服务器的数据1
			success:function(data){ //请求成功后的回调函数。
				$("html").html(data);
			}
		})
	}

//查看物流
function checkLog(id) {
		$.ajax({
			url:"checkLog", //发送请求的地址
			type:"post", //请求方式 ("POST" 或 "GET")
			data:{"id":id},  //发送到服务器的数据1
			success:function(data){ //请求成功后的回调函数。
				$("html").html(data);
				
			}
		})
	}
//返回方法
function backOrder() {
	
	window.location.href="order_list";
}
