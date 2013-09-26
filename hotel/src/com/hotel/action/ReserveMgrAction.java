package com.hotel.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;


import com.hotel.dao.ReserveDAO;
import com.hotel.tool.Pager;
import com.opensymphony.xwork2.ActionSupport;

public class ReserveMgrAction extends ActionSupport {

	private ReserveDAO reserveDao;
	private Pager reservePager;
	public String getPagerReserves()
	{
		//可以自己传pageSize.我们人为认定了pageSize
		HttpServletRequest request= ServletActionContext.getRequest();
		int pagenow=Integer.parseInt(request.getParameter("pagenow"));
		String module = request.getParameter("module");
		if(pagenow<=0)
		{
			pagenow = 1;
		}
		reservePager = reserveDao.getPageData(3, pagenow);
		return module;
	}
	
	public String index()
	{
		reservePager = reserveDao.getPageData(3, 1);
		return "index";
	}

	public String chk()
	{
		reservePager = reserveDao.getPageData(3, 1);
		return "chk";
	}
	public String success()
	{
		reservePager = reserveDao.getPageData(3, 1);
		return "success";
	}
	public String serch()
	{
		reservePager = reserveDao.getPageData(3, 1);
		return "serch";
	}
	public ReserveDAO getReserveDao() {
		return reserveDao;
	}
	@Resource(name="reserveDao")
	public void setReserveDao(ReserveDAO reserveDao) {
		this.reserveDao = reserveDao;
	}

	public Pager getReservePager() {
		return reservePager;
	}
	
	
	public void setReservePager(Pager reservePager) {
		this.reservePager = reservePager;
	}
	
}
