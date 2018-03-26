/**
 * 商品类型js
 */
//去新增
function productType_to_edit() {
		$.ajax({
			url:"productType_to_edit", //发送请求的地址
			type:"get", //请求方式 ("POST" 或 "GET")
			success:function(data){ //请求成功后的回调函数。
				window.location.href=data;//需要跳转的地址
			}
		})
	}

//去修改
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
	$.ajax({
		url:"productType_edit", //发送请求的地址
		type:"post", //请求方式 ("POST" 或 "GET")
		data:$("form").serialize(),  //发送到服务器的数据1
		dataType:"html",
		success:function(data){ //请求成功后的回调函数。
			$("html").html(data);
			window.location.reload();
		}
	})
}
//返回方法
function back() {
	$.ajax({
		url:"productType_list", //发送请求的地址
		type:"post", //请求方式 ("POST" 或 "GET")
		data:{},  //发送到服务器的数据1
		dataType:"html",
		success:function(data){ //请求成功后的回调函数。
			$("html").html(data);
			window.location.reload();
		}
	})
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
		success:function(data){ //请求成功后的回调函数。
			$("html").html(data);
			window.location.reload();
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
		window.location.reload();
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
			$("html").html(data);
		}
	})
}


/**
 * 商品js
 */
//去修改
function product_to_edit(id){
	$.ajax({
		url:"product_to_edit", //发送请求的地址
		type:"post", //请求方式 ("POST" 或 "GET")
		data:{"id":id},  //发送到服务器的数据1
		success:function(data){ //请求成功后的回调函数。
			$("html").html(data);
		}
	})
}

//修改方法
function product_edit() {
	var formData = new FormData();
	 formData.append("id", $("#id").val());
	 formData.append("productName", $("#productName").val());
	 formData.append("number", $("#number").val());
	 formData.append("price", $("#price").val());
	 formData.append("description", $("#description").val());
	 formData.append("typeName", $("#typeName").val());
	 formData.append("file", $("#imgUrl")[0].files[0]);
	$.ajax({
		url:"product_edit", //发送请求的地址
		type:"post", //请求方式 ("POST" 或 "GET")
		data:formData,  //发送到服务器的数据1
		contentType: false,
        processData: false,
		success:function(data){ //请求成功后的回调函数。
			$("html").html(data);
			window.location.reload();
		}
	})
}

//返回方法
function back_productList() {
	$.ajax({
		url:"product_list", //发送请求的地址
		type:"post", //请求方式 ("POST" 或 "GET")
		data:{},  //发送到服务器的数据1
		dataType:"html",
		success:function(data){ //请求成功后的回调函数。
			$("html").html(data);
			window.location.reload();
		}
	})
}

//删除方法
function delete_product(id) {
	var con;
	con=confirm("确定删除该商品?");
	if(con){
		product_delete(id);
		window.location.reload();
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
			$("html").html(data);
		}
	})
}

function preview(file) {
	  var prev = $("#right-add-center-right img");
	  if (file.files && file.files[0]) {
	   var reader = new FileReader();
	   reader.onload = function (evt) {
	   prev.attr("src",evt.target.result);   
	   }
	   reader.readAsDataURL(file.files[0]);
	  }
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

//删除方法
function delete_order(id) {
	var con;
	con=confirm("确定删除该用户?");
	if(con){
		user_delete(id);
		return true;
	}	
	return false;
}

function user_delete(id) {
	$.ajax({
		url:"user_delete", //发送请求的地址
		type:"post", //请求方式 ("POST" 或 "GET")
		data:{"id":id},  //发送到服务器的数据1
		success:function(data){ //请求成功后的回调函数。
			$("html").html(data);
			window.location.reload();
		}
	})
}