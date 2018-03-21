function exeData(num, type) {
    loadData(num);
    loadpage();
}
var pageNo=1;

function loadpage() {
    var myPageCount = parseInt($("#PageCount").val());
    var myPageSize = parseInt($("#PageSize").val());
    var countindex = myPageCount % myPageSize > 0 ? (myPageCount / myPageSize) + 1 : (myPageCount / myPageSize);
    $("#countindex").val(countindex);
    $("span:first").html(pageNo);
    $("span:eq(1)").html(parseInt(countindex));
    $("span:last").html(myPageCount);
    var pages=parseInt(countindex);
    
    
    $.jqPaginator('#pagination', {
        totalPages: parseInt($("#countindex").val()),
        visiblePages: parseInt($("#visiblePages").val()),
        currentPage: pageNo,
        first: '<li class="first"><a onclick="selectPage(1)">首页</a></li>',
        prev: '<li class="prev"><a onclick=selectPage('+100+')><i class="arrow arrow2"></i>上一页</a></li>',
        next: '<li class="next"><a onclick="selectPage('+101+')">下一页<i class="arrow arrow3"></i></a></li>',
        last: '<li class="last"><a onclick=selectPage('+pages+')>末页</a></li>',
        page: '<li class="page"><a onclick="selectPage({{page}})">{{page}}</a></li>',
        onPageChange: function (num, type) {
        	
            if (type == "change") {
            	pageNo=num;
                exeData(num, type);
            }
        }
    });
}
$(function () {
    loadData(1);
    loadpage();
});