package com.project.model;

import java.util.Arrays;
import java.util.List;

public class Page {

	//当前页
    private int pageNum;
    //页面记录数
    private int pageSize=5;
    //总记录数
    private int total;
    //总页数
    private int pages;
    //前一页
    private int prePage;
    //下一页
    private int nextPage;
    //结果集
    private List<?> list;
    //导航页码数
    private int navigatePages=5;
    //所有导航页号
    private int[] navigatepageNums;
    
    public void print() {
    	//总页数小于导航页数
    	if(pages<navigatePages) {
    		navigatePages=pages;
    		navigatepageNums=new int[navigatePages];
    		for (int i = 0; i < navigatepageNums.length; i++) {
    			navigatepageNums[i]=i+1;
			}	
    	}else {
    		navigatepageNums=new int[navigatePages];
    		if(pageNum==1||pageNum==2||pageNum<1) {
    			for (int i = 0; i < navigatepageNums.length; i++) {
        			navigatepageNums[i]=i+1;
    			}
    		} else if(pageNum==pages||pageNum==pages-1) {
    			for (int i = 0; i < navigatepageNums.length; i++) {
        			navigatepageNums[i]=pages+i-4;
    			}
    		}else {
    			for (int i = 0; i < navigatepageNums.length; i++) {
        			navigatepageNums[i]=pageNum-2+i;
    			}
    		}
    	}
    	//判断上一页
    	if(pageNum>1) {
    		prePage=pageNum-1;
    	} else {
    		prePage=1;
    	}
    	//判断下一页
    	if(pageNum<pages) {
    		nextPage=pageNum+1;
    	}else {
    		nextPage=pages;
    	}
    }
    
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public int getNavigatePages() {
		return navigatePages;
	}
	public void setNavigatePages(int navigatePages) {
		this.navigatePages = navigatePages;
	}
	public int[] getNavigatepageNums() {
		return navigatepageNums;
	}
	public void setNavigatepageNums(int[] navigatepageNums) {
		this.navigatepageNums = navigatepageNums;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Page(List<?> list, int navigatePages) {
		super();
		this.list = list;
		this.navigatePages = navigatePages;
	}
	public Page(List<?> list) {
		super();
		this.list = list;
	}
	public Page() {
		super();
	}
	
	@Override
	public String toString() {
		return "Page [pageNum=" + pageNum + ", pageSize=" + pageSize + ", pages=" + pages + ", prePage=" + prePage
				+ ", nextPage=" + nextPage + ", list=" + list + ", navigatePages=" + navigatePages
				+ ", navigatepageNums=" + Arrays.toString(navigatepageNums)+ "]";
	}
    
    
}
