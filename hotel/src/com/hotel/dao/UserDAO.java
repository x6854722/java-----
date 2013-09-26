package com.hotel.dao;

import java.util.List;

import com.hotel.tool.Pager;
import com.hotel.vo.UserVO;

public interface UserDAO {

	public boolean insertUser(UserVO uservo);
	public boolean logUser(UserVO uservo);
	
	
	public UserVO findUserById(String userId);
	public List getAllUsers();
	
	
	 
	/**
	 * 
	 * @param userId
	 * @param pageSize
	 * @param pageNow
	 * @param serchType * @param serchType 搜索选项 :all----所有订单  success----成功订单  needchk----待审核订单
	 * @return
	 */
	public Pager getReservePageData(String userId,int pageSize, int pageNow,String serchType);
	
	public int getTotalRows(String userId,String serchType) ;
	
	public List getPageData(String userId, int firstRow, int maxRow,String serchType);
}
