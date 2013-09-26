package com.hotel.dao;

import java.util.List;

import com.hotel.tool.Pager;
import com.hotel.vo.ReserveVO;

public interface ReserveDAO {

public boolean insertReserve(ReserveVO reserveVo);

	
	public boolean modifyReserve(ReserveVO reserveVo);

	
	public boolean removeReserve(String id);

	
	public ReserveVO findReserveById(String id);

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
