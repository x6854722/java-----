package com.hotel.dao;

import java.util.List;

import com.hotel.tool.Pager;
import com.hotel.vo.RoomVO;

public interface RoomDAO {

	public boolean insertRoom(RoomVO roomVo);

	
	public boolean modifyRoom(String id, RoomVO roomVo);

	
	public boolean removeRoom(String id);

	
	public List<RoomVO> findRoomById(String id);

	
	public RoomVO findRoomByRoomId(String roomid);
	/*
	 * 
	 * jdbc 分页查询
	 */
	public List getPage(int firstRow,int maxRow);
	/*
	 * 
	 * 获取总条数
	 */
	public int getTotalRows();
	/*
	 * 获取指定分页
	 */
	public Pager getPageData(int pageSize,int pageNow);
	
	
}
