package com.hotel.action;


import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.hotel.dao.ReserveDAO;
import com.hotel.dao.UserDAO;
import com.hotel.tool.HandleCookie;
import com.hotel.tool.Pager;
import com.hotel.vo.UserVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	
	private UserDAO userdao;
	private HandleCookie handleCookie;
	private HttpServletRequest request;
	private String tipMsg;
	private UserVO uservo;
	
	private Pager reservePager;
	
	public String input()
	{
		return "input";
	}
	public String test()
	{
		UserVO uservo = new UserVO();        
		uservo.setUserName("俩白");            
		
		userdao.insertUser(uservo);          
		return "test";
	}
	public String getPagerReserves()
	{
		//可以自己传pageSize.我们人为认定了pageSize
		HttpServletRequest request= ServletActionContext.getRequest();
		int pagenow=Integer.parseInt(request.getParameter("pagenow"));
		String userId = request.getParameter("userId");
		if(pagenow<=0)
		{
			pagenow = 1;
		}
		reservePager = userdao.getReservePageData(userId, 2, 1, "all");
		return "success";
	}
	
	
	public String login() throws UnsupportedEncodingException
	{
		
		request = ServletActionContext.getRequest();		
		String yancode = (String) request.getSession().getAttribute("SESSION_SECURITY_CODE");
		handleCookie = getHandleCookie();
		String logfail=handleCookie.getCookie("logfail");
		if(logfail==null)
		{
			if(yancode.equals(request.getParameter("yancode")))
			{
				uservo = new UserVO();
				uservo.setUserId(request.getParameter("userid"));
				uservo.setUserPassword(request.getParameter("password"));
				if(userdao.logUser(uservo))
				{
					handleCookie.delCookie("logfail");
					if(uservo.getUserId().equals("admin")){
						request.getSession().setAttribute("SESSION_USER_ID", uservo.getUserId());
						return "admin";
					}
					request.getSession().setAttribute("SESSION_USER_ID", uservo.getUserId());
					uservo = userdao.findUserById(uservo.getUserId());
					reservePager = userdao.getReservePageData(uservo.getUserId(), 2, 1, "all");///获取当前用户的订单
					return "success";
				}
				
				tipMsg = "登录失败 ,用户名或者密码错误";
				
			}else
			{
				tipMsg = "登录失败 ,验证码不匹配";
			}
			handleCookie.addCookie("logfail", "1");
			
		}else if(Integer.valueOf(logfail)<4)
		{
			if(yancode.equals(request.getParameter("yancode")))
			{
				uservo = new UserVO();
				uservo.setUserId(request.getParameter("userid"));
				uservo.setUserPassword(request.getParameter("password"));
				if(userdao.logUser(uservo))
				{
					handleCookie.delCookie("logfail");
					if(uservo.getUserId().equals("admin")){
						request.getSession().setAttribute("SESSION_USER_ID", uservo.getUserId());
						return "admin";
					}
					request.getSession().setAttribute("SESSION_USER_ID", uservo.getUserId());
					uservo = userdao.findUserById(uservo.getUserId());
					return "success";
				}
				tipMsg = "登录失败 ,用户名或者密码错误";
			}else
			{
				tipMsg = "登录失败 ,验证码不匹配";
			}
			handleCookie.addCookie("logfail", String.valueOf((Integer.valueOf(logfail)+1)));
		}else
		{
			tipMsg = "登陆三次失败  ,您的账户将被锁定几分钟。";
		}
		return "input";
	}
	
	public String info()
	{
		request = ServletActionContext.getRequest();
		String userId = request.getParameter("userId");
		uservo = userdao.findUserById(userId);
		return "info";
	}
	public String chginfo()
	{
		request = ServletActionContext.getRequest();
		String userId = request.getParameter("userId");
		uservo = userdao.findUserById(userId);
		return "chginfo";
	}
	public String chgpwd()
	{
		request = ServletActionContext.getRequest();
		String userId = request.getParameter("userId");
		uservo = userdao.findUserById(userId);
		return "chgpwd";
	}
	
	public String logoff()
	{
		request = ServletActionContext.getRequest();
		request.getSession().removeAttribute("SESSION_USER_ID");
		return "input";
	}
	public UserDAO getUserdao() {
		return userdao;
	}
	@Resource(name="userdao")
	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}
	
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public HandleCookie getHandleCookie() {
		return new HandleCookie();
	}
	public void setHandleCookie(HandleCookie handleCookie) {
		this.handleCookie = handleCookie;
	}
	public String getTipMsg() {
		return tipMsg;
	}
	public void setTipMsg(String tipMsg) {
		this.tipMsg = tipMsg;
	}
	public UserVO getUservo() {
		return uservo;
	}
	public void setUservo(UserVO uservo) {
		this.uservo = uservo;
	}
	
	public Pager getReservePager() {
		return reservePager;
	}
	public void setReservePager(Pager reservePager) {
		this.reservePager = reservePager;
	}
	

}
