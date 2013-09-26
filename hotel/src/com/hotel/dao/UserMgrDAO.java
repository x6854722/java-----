package com.hotel.dao;

import java.util.List;

import com.hotel.tool.Pager;
import com.hotel.vo.UserVO;

public interface UserMgrDAO {

	public List<UserVO> getAllUsers();
	public boolean isExist(String  user_id);
	public boolean deleteUser(String user_id);
	public boolean chkpwd(String userId,String pwd);
	public boolean insertUser(UserVO uservo);
	public List getPage(int firstRow,int maxRow);
	public Pager getPageData(int pageSize,int pageNow);
	public int getTotalRows();
}
