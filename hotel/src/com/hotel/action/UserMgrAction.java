package com.hotel.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.json.simple.JSONObject;
import com.hotel.dao.UserDAO;
import com.hotel.dao.UserMgrDAO;
import com.hotel.tool.Pager;
import com.hotel.vo.UserVO;
import com.opensymphony.xwork2.ActionSupport;

public class UserMgrAction extends ActionSupport {

	private UserMgrDAO usermgrDao;
	private UserDAO userdao;
	private Pager userPager;
	private UserVO uservo;
	private JSONObject json;
	public String getPagerUsers()
	{
		//可以自己传pageSize.我们人为认定了pageSize
		HttpServletRequest request= ServletActionContext.getRequest();
		int pagenow=Integer.parseInt(request.getParameter("pagenow"));
		if(pagenow<=0)
		{
			pagenow = 1;
		}
		userPager = usermgrDao.getPageData(3, pagenow);
		return "usermgr";
	}
	public String usermgr()
	{
		userPager = usermgrDao.getPageData(3, 1);
		return "usermgr";
	}
	public String deleteUser()
	{
		HttpServletRequest request= ServletActionContext.getRequest();
		String user_id=request.getParameter("user_id");
		if(usermgrDao.isExist(user_id))
		{
			usermgrDao.deleteUser(user_id);
		}
		userPager = usermgrDao.getPageData(2, 1);
		return "usermgr";
	}
	public String look()
	{
		HttpServletRequest request= ServletActionContext.getRequest();
		String user_id=request.getParameter("user_id");
		System.out.println("ID" + user_id);
		if(usermgrDao.isExist(user_id))
		{
			uservo = userdao.findUserById(user_id);
		}
		return "look";
	}
	public String chkpwdDeal()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String userid = request.getParameter("userId");
		String repwd = request.getParameter("passwordUpdateData");
		if(usermgrDao.chkpwd(userid, repwd))
		{
			json = new JSONObject();
			json.put("status", "success");
			json.put("title", "修改密码结果");
			json.put("msg", "修改密码，成功");
		}else
		{
			json = new JSONObject();
			json.put("status", "fail");
			json.put("title", "修改密码结果");
			json.put("msg", "修改密码结，失败");
		}
		return "success";
	}

	public String addUser(){
		HttpServletRequest request = ServletActionContext.getRequest();
		uservo = new UserVO();
		uservo.setAddress(request.getParameter("userAddr"));
		uservo.setAge(Integer.parseInt(request.getParameter("userAge")));
		uservo.setApplyTime(request.getParameter("userRegtime"));
		uservo.setBirthday(request.getParameter("userBirthday"));
		uservo.setCertiType(request.getParameter("CertiType"));
		uservo.setCertiNum(request.getParameter("CertiNum"));
		uservo.setEmail(request.getParameter("userEmail"));
		uservo.setMobile(request.getParameter("userPhone"));
		uservo.setSex(request.getParameter("userSex"));
		uservo.setUserId(request.getParameter("userId"));
		uservo.setUserName(request.getParameter("userName"));
		uservo.setUserPassword(request.getParameter("userPwd"));
		System.out.println("uservo = " + uservo);
		if(usermgrDao.insertUser(uservo))
		{
			json = new JSONObject();
			json.put("status", "success");
			json.put("title", "添加用户，提示");
			json.put("msg", "添加用户，成功");
		}else{
			json = new JSONObject();
			json.put("status", "fail");
			json.put("title", "添加用户，提示");
			json.put("msg", "添加用户，失败");
		}		
		return "success";
	}
	public UserMgrDAO getUsermgrDao() {
		return usermgrDao;
	}


	@Resource(name="usermgrDao")
	public void setUsermgrDao(UserMgrDAO usermgrDao) {
		this.usermgrDao = usermgrDao;
	}


	public Pager getUserPager() {
		return userPager;
	}


	public void setUserPager(Pager userPager) {
		this.userPager = userPager;
	}


	public UserDAO getUserdao() {
		return userdao;
	}


	@Resource(name="userdao")
	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}


	public UserVO getUservo() {
		return uservo;
	}


	public void setUservo(UserVO uservo) {
		this.uservo = uservo;
	}
	public JSONObject getJson() {
		return json;
	}
	public void setJson(JSONObject json) {
		this.json = json;
	}
	
}
