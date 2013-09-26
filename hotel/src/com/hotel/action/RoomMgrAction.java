package com.hotel.action;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.json.simple.JSONObject;

import com.hotel.dao.RoomDAO;

import com.hotel.tool.Pager;
import com.hotel.vo.RoomVO;
import com.opensymphony.xwork2.ActionSupport;
//房间管理 房间单价管理
public class RoomMgrAction extends ActionSupport {

	private RoomDAO roomDao;
	private Pager roomPager;
	private JSONObject  json;
	public String getPagerRooms()
	{
		//可以自己传pageSize.我们人为认定了pageSize
		HttpServletRequest request= ServletActionContext.getRequest();
		int pagenow=Integer.parseInt(request.getParameter("pagenow"));
		if(pagenow<=0)
		{
			pagenow = 1;
		}
		roomPager = roomDao.getPageData(3, pagenow);
		return "index";
	}
	public String getPagerRoomPrice()
	{
		//可以自己传pageSize.我们人为认定了pageSize
		HttpServletRequest request= ServletActionContext.getRequest();
		int pagenow=Integer.parseInt(request.getParameter("pagenow"));
		if(pagenow<=0)
		{
			pagenow = 1;
		}
		roomPager = roomDao.getPageData(3, pagenow);
		return "price";
	}
	
	public String addRoom()
	{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		RoomVO roomvo = new RoomVO();
		roomvo.setRoomId(request.getParameter("roomId"));
		roomvo.setRoomName(request.getParameter("roomName"));
		roomvo.setStatus(request.getParameter("roomState"));
		roomvo.setAvailable(request.getParameter("roomAvailable"));
		roomvo.setPrice(Float.parseFloat(request.getParameter("price")));
		roomvo.setDiscountPrice(Float.parseFloat(request.getParameter("discountPrice")));
		roomvo.setHotelId("A001");
		
		System.out.println("name="+roomvo);
		json= new JSONObject();
	    
	    if(roomDao.insertRoom(roomvo))
	    {
	    	json.put("status","success");
	    	json.put("title", "添加房间");
	    	json.put("msg", "添加房间 ，，成功");
	    }else
	    {
	    	json.put("status","fail");
	    	json.put("title", "添加房间");
	    	json.put("msg", "添加房间 ，，失败");
	    }
	    
		
		return  "success";
	}
	
	public String rePrice()
	{
		
		
		return "success";
	}
	public String price()
	{
		roomPager = roomDao.getPageData(3, 1);
		return "price";
	}
	public String index()
	{
		roomPager = roomDao.getPageData(3, 1);
		return "index";
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
