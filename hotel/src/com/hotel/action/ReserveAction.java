package com.hotel.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.json.simple.JSONObject;

import com.hotel.dao.ReserveDAO;
import com.hotel.dao.RoomDAO;
import com.hotel.dao.UserDAO;
import com.hotel.tool.Pager;
import com.hotel.vo.ReserveVO;
import com.hotel.vo.RoomVO;
import com.hotel.vo.UserVO;
import com.opensymphony.xwork2.ActionSupport;

public class ReserveAction extends ActionSupport {

	private HttpServletRequest request;
	private ReserveDAO reserveDao;
	private Pager reservePager;
	private UserDAO userDao;
	private UserVO uservo;
	private RoomDAO roomDao;
	private Pager roomPager;
	private JSONObject json;
	public String index()
	{
		request = ServletActionContext.getRequest();
		String userId = request.getParameter("userId");
		uservo = userDao.findUserById(userId);
		
		roomPager = roomDao.getPageData(5, 1);
		return "index";
	}
	public String moreRooms()
	{
		request = ServletActionContext.getRequest();
		String userId = request.getParameter("userId");
		int pagenow=Integer.parseInt(request.getParameter("pagenow"));
		if(pagenow<=0)
		{
			pagenow = 1;
		}		
		uservo = userDao.findUserById(userId);
		
		roomPager = roomDao.getPageData(5, pagenow);
		return "index";
	}
	
	public String reserve()
	{
		request = ServletActionContext.getRequest();
		
//		System.out.println("userId="+request.getParameter("userId"));
//		System.out.println("reserveId="+request.getParameter("reserveId"));
//		System.out.println("roomId="+request.getParameter("roomId"));
//		System.out.println("startTime="+request.getParameter("startTime"));
//		System.out.println("overTime="+request.getParameter("overTime"));
//		
		boolean suc=true;
		String[] roomIds = request.getParameterValues("roomId");
		for(int i=0;i<roomIds.length;i++){
			String romeId = roomIds[i];
			RoomVO roomvo = roomDao.findRoomByRoomId(romeId);
			ReserveVO reservevo = new ReserveVO();
			reservevo.setUserId(request.getParameter("userId"));
			reservevo.setHotelId(roomvo.getHotelId());
			reservevo.setNeedchk("需要审查");
			reservevo.setPrice(roomvo.getPrice());
			reservevo.setStartTime(request.getParameter("startTime"));
			reservevo.setOverTime(request.getParameter("overTime"));
			reservevo.setReserveId(request.getParameter("reserveId"));
			reservevo.setRoomId(romeId);
			reservevo.setStatus(roomvo.getStatus());
			reservevo.setTotal(roomvo.getPrice());
			if(!reserveDao.insertReserve(reservevo))
			{
				suc=false;
			}
		}
		if(suc)
		{
			json = new JSONObject();
			json.put("status", "success");
			json.put("title", "预定房间，提示");
			json.put("msg", "预定房间，成功");
		}else
		{
			json = new JSONObject();
			json.put("status", "fail");
			json.put("title", "预定房间，提示");
			json.put("msg", "预定房间，失败");
		}
		return "success";
	}
	public String all()
	{
		request = ServletActionContext.getRequest();
		String userId = request.getParameter("userId");
		uservo = userDao.findUserById(userId);
		reservePager = userDao.getReservePageData(userId, 2, 1, "all");
		return "all";
	}
	public String needchk()
	{
		request = ServletActionContext.getRequest();
		String userId = request.getParameter("userId");
		uservo = userDao.findUserById(userId);
		reservePager = userDao.getReservePageData(userId, 2, 1, "needchk");
		return "needchk";
	}
	public String suc()
	{
		request = ServletActionContext.getRequest();
		String userId = request.getParameter("userId");
		uservo = userDao.findUserById(userId);
		reservePager = userDao.getReservePageData(userId, 2, 1, "success");
		return "suc";
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
	public UserDAO getUserDao() {
		return userDao;
	}
	@Resource(name="userdao")
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	public UserVO getUservo() {
		return uservo;
	}
	public void setUservo(UserVO uservo) {
		this.uservo = uservo;
	}
	public RoomDAO getRoomDao() {
		return roomDao;
	}
	@Resource(name="roomDao")
	public void setRoomDao(RoomDAO roomDao) {
		this.roomDao = roomDao;
	}
	public Pager getRoomPager() {
		return roomPager;
	}
	public void setRoomPager(Pager roomPager) {
		this.roomPager = roomPager;
	}
	public JSONObject getJson() {
		return json;
	}
	public void setJson(JSONObject json) {
		this.json = json;
	}
}
