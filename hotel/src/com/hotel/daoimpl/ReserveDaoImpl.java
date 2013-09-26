package com.hotel.daoimpl;

import  com.hotel.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import com.hotel.dao.ReserveDAO;
import com.hotel.tool.Pager;
import com.hotel.vo.ReserveVO;


@Component("reserveDao")
public class ReserveDaoImpl implements ReserveDAO {

	private  DataSource dataSource;
	public boolean insertReserve(ReserveVO reserveVo) {
		// TODO Auto-generated method stub
		if (null == reserveVo || "".equals(reserveVo)) {
			return false;
		}
		Connection conn = null;
		PreparedStatement pstm = null;
		String sql = "INSERT INTO T_Reserve(reserve_Id,reserve_RoomId,reserve_HotelId,reserve_UserId,reserve_Quantity,reserve_People,reserve_Price,reserve_Total,reserve_StartTime,reserve_OverTime,reserve_Status) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		try {

			System.out.println("insertReserve sql=" + sql);
			conn = dataSource.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, reserveVo.getReserveId());
			pstm.setString(2, reserveVo.getRoomId());
			pstm.setString(3, reserveVo.getHotelId());
			pstm.setString(4, reserveVo.getUserId());
			pstm.setInt(5, reserveVo.getQuantity());
			pstm.setInt(6, reserveVo.getPeople());
			pstm.setFloat(7, reserveVo.getPrice());
			pstm.setFloat(8, reserveVo.getTotal());
			pstm.setString(9, sdf.format(formatter.parse(reserveVo.getStartTime())));
			pstm.setString(10, sdf.format(formatter.parse(reserveVo.getOverTime())));
			pstm.setString(11, reserveVo.getStatus());

			int i = pstm.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.closeConnection(conn, pstm);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean modifyReserve(ReserveVO reserveVo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;		
		String sql = "UPDATE T_Reserve SET reserve_Status = '" + reserveVo.getStatus()
				+ "', reserve_needchk = '" + reserveVo.getNeedchk()
				+ "' WHERE reserve_Id = '" + reserveVo.getReserveId() + "'";
		
		try {
			System.out.println("modifyReserve sql=" + sql);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			int i = pstmt.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.closeConnection(conn, pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean removeReserve(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		String sql = "DELETE FROM T_Reserve WHERE reserve_id = '" + id + "'";
		try {

			System.out.println("removeReserve sql=" + sql);
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			int i = pstm.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.closeConnection(conn, pstm);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public ReserveVO findReserveById(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM T_Reserve WHERE reserve_Id='" + id+"'";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			System.out.println("findAdminById sql=" + sql);
			rs = pstmt.executeQuery();
			rs.next();
			
			ReserveVO reserveVo = new ReserveVO();
			reserveVo.setReserveId(rs.getString("reserve_id"));
			reserveVo.setRoomId(rs.getString("reserve_roomid"));
			reserveVo.setUserId(rs.getString("reserve_userid"));
			reserveVo.setPrice(rs.getFloat("reserve_price"));
			reserveVo.setTotal(rs.getFloat("reserve_total"));
			reserveVo.setStartTime(sdf.format(rs.getDate("reserve_startTime")));
			reserveVo.setOverTime(sdf.format(rs.getDate("reserve_overTime")));
			reserveVo.setStatus(rs.getString("reserve_status"));
			reserveVo.setNeedchk(rs.getString("reserve_needchk"));
			reserveVo.setHotelId(rs.getString("reserve_hotelId"));
			reserveVo.setQuantity(rs.getInt("reserve_quantity"));
			reserveVo.setPeople(rs.getInt("reserve_people"));
			return reserveVo;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, pstmt, rs);
		}
	
		return null;
	}

	
	///分页
	public List getPage(int firstRow, int maxRow) {
		// TODO Auto-generated method stub
	   String sql = "select * from t_reserve";
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   try{
		   System.out.println("login sql=" + sql);
		   conn = dataSource.getConnection();
		   pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		   pstmt.setMaxRows(firstRow+maxRow);
		   ResultSet rs = pstmt.executeQuery();
		   rs.first();
		   rs.relative(firstRow);
		   
		   List<ReserveVO> reserves = new ArrayList<ReserveVO>();
		   
		   do{		   
			   	ReserveVO reserveVo = new ReserveVO();
				reserveVo.setReserveId(rs.getString("reserve_id"));
				reserveVo.setRoomId(rs.getString("reserve_roomid"));
				reserveVo.setUserId(rs.getString("reserve_userid"));
				reserveVo.setPrice(rs.getFloat("reserve_price"));
				reserveVo.setTotal(rs.getFloat("reserve_total"));
				reserveVo.setStartTime(sdf.format(rs.getDate("reserve_startTime")));
				reserveVo.setOverTime(sdf.format(rs.getDate("reserve_overTime")));
				reserveVo.setStatus(rs.getString("reserve_status"));
				reserveVo.setNeedchk(rs.getString("reserve_needchk"));
				reserveVo.setHotelId(rs.getString("reserve_hotelId"));
				reserveVo.setQuantity(rs.getInt("reserve_quantity"));
				reserveVo.setPeople(rs.getInt("reserve_people"));
				reserves.add(reserveVo);
				
		   }while(rs.next());
		   return reserves;
	   } catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.closeConnection(conn, pstmt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	   return  null;
	}

	public int getTotalRows() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(reserve_id) FROM T_Reserve";
				
		try {
			System.out.println("login sql=" + sql);
			conn = dataSource.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			rs.next();
			int i = rs.getInt(1);
			if (i > 0) {
				return i;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return 0;
	}

	public Pager getPageData(int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		int rowCount = getTotalRows();
		
		if(pageSize <= 0 )
		{
			pageSize=5;
		}
		Pager pager = new Pager(pageSize,pageNow,rowCount);
		pager.setData(getPage((pager.getPagenow()-1)*pager.getPageSize(),pager.getPageSize()));
		return pager;
	}

	public DataSource getDataSource() {
		return dataSource;
	}
	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
