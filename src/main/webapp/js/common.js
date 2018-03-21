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

//删除方法
function delete_user(id) {
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
	$.ajax({
		url:"product_edit", //发送请求的地址
		type:"post", //请求方式 ("POST" 或 "GET")
		data:$("form").serialize(),  //发送到服务器的数据1
		success:function(data){ //请求成功后的回调函数。
			$("html").html(data);
		}
	})
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
			$("html").html(data);
		}
	})
}