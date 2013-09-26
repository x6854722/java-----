package com.hotel.tool;

import java.util.ArrayList;
import java.util.List;

public class Pager {
    /*
     * 
     * 分页算法
     */
	private int pageSize; //页大小 已设  固定

	private int pageCount; //总页数 (计算得出)已设  固定

	private List data=new ArrayList(); //数据总内容

	private int pagenow; //当前页码 已设 

	private int dataCount; //数据总行数 已设 固定
	
	private boolean noNext=false;//已经没有下一页   页面判断如果没有上一页的话，就不显示上一页的连接
	
	private boolean noPrev=true;//已经没有上一页  页面判断如果没有下一页的话，就不显示下一页的连接
	public Pager(int pageSize, int pageNow ,int dataCount)
	{
		this.pageSize = pageSize;
		this.pagenow = pageNow;
		this.dataCount = dataCount;
		if(dataCount%pageSize==0)
		{
			this.setPageCount(dataCount/pageSize);
		}
		else
		{
			this.setPageCount((int)Math.floor(dataCount/pageSize)+1);
		}
		if(pageNow ==1)
		{
			
			this.noPrev = true;
		}
		else
		{
			this.noPrev = false;
		}
		if(dataCount <= pageSize || this.pageCount == this.pagenow)
		{
			noNext = true;
		}
	}
	public Pager(int dataCount)
	{
		this.pageSize = 5;
		this.pagenow = 1;
		this.dataCount = dataCount;
		if(dataCount%pageSize==0)
		{
			this.setPageCount(dataCount/pageSize);
		}
		else
		{
			this.setPageCount((int)Math.floor(dataCount/pageSize)+1);
		}
		if(dataCount <= pageSize)
		{
			noNext = true;
		}
	}
	public void pageDown(List sourceData)
	{
		 pagenow+=1;
		 if(pagenow == pageCount)
		 {
			 noNext = true;
		 }
		 this.data = sourceData;
	}
	public void pageUp(List sourceData)
	{
		pagenow-=1;
		if(pagenow == 1)
		{
			noPrev = true; 
		}
		this.data = sourceData;
	}
	public void firstPage(List sourceData)
	{
		noPrev = true;
		this.data = sourceData;
	}
	public void lastPage(List sourceData)
	{
		noNext = true;
		this.data = sourceData;
	}
	
	
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	

	public int getDataCount() {
		return dataCount;
	}

	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}

	public int getPagenow() {
		return pagenow;
	}

	public void setPagenow(int pagenow) {
		this.pagenow = pagenow;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public boolean isNoNext() {
		return noNext;
	}
	public void setNoNext(boolean noNext) {
		this.noNext = noNext;
	}
	public boolean isNoPrev() {
		return noPrev;
	}
	public void setNoPrev(boolean noPrev) {
		this.noPrev = noPrev;
	}
	@Override
	public String toString() {
		return "Pager [data=" + data + ", dataCount=" + dataCount + ", noNext="
				+ noNext + ", noPrev=" + noPrev + ", pageCount=" + pageCount
				+ ", pageSize=" + pageSize + ", pagenow=" + pagenow + "]";
	}

	
}
