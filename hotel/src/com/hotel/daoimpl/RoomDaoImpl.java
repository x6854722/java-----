package com.hotel.daoimpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.hotel.dao.RoomDAO;
import com.hotel.dao.UserDAO;
import com.hotel.db.DBConnection;
import com.hotel.tool.Pager;
import com.hotel.vo.RoomVO;
import com.hotel.vo.UserVO;

@Component("roomDao")
public class RoomDaoImpl implements RoomDAO{

	private DataSource dataSource;
	public boolean insertRoom(RoomVO roomVo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;

		String sql = "INSERT INTO T_Room(room_id,room_status,room_Available,room_name,room_price,room_discoutPrice,room_hotelId) VALUES(?,?,?,?,?,?,?)";
		try {

			conn = dataSource.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, roomVo.getRoomId());
			pstm.setString(2, roomVo.getStatus());
			pstm.setString(3, "Y"); //// 房间是否可以使用 "Y"表示可以 "N"表示不可以
			pstm.setString(4, roomVo.getRoomName());
			pstm.setFloat(5, roomVo.getPrice());
			pstm.setFloat(6, roomVo.getDiscountPrice());
			pstm.setString(7, roomVo.getHotelId());

			System.out.println("insertRoom sql=" + sql);
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

	public boolean modifyRoom(String id, RoomVO roomVo) {
		// TODO Auto-generated method stub
		String status = id;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		//1 & 2  打折与不打折
		if (status.equals("1")) {
			sql = "UPDATE T_Room SET room_Status = '" + roomVo.getStatus()
					+ "', room_Available = '" + roomVo.getAvailable()
					+ "' WHERE room_Id = '" + roomVo.getRoomId() + "'";
		}
		if (status.equals("2")) {

			sql = "UPDATE T_Room SET room_Status = '" + roomVo.getStatus()
					+ "', room_Available = '" + roomVo.getAvailable()
					+ "', room_discoutPrice = '" + roomVo.getDiscountPrice()
					+ "' WHERE room_Id = '" + roomVo.getRoomId() + "'";
		}
		try {
			System.out.println("modifyRoom sql=" + sql);
			conn = DBConnection.getConnection();
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

	public boolean removeRoom(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;

		String sql = "DELETE FROM T_Room WHERE room_Id = '" + id + "'";
		try {

			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);

			System.out.println("insertRoom sql=" + sql);
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

	public List<RoomVO> findRoomById(String id) {
		// TODO Auto-generated method stub
		ArrayList<RoomVO> list = new ArrayList<RoomVO>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "";
		//1 表示 查询所有的可用房间
		//2 表示 按房间Id 查询具体的房间
		if (id.equals("1")) {
			sql = "SELECT room_Id,room_Price FROM T_Room WHERE room_Available = '"
					+ "Y" + "'";
		} else {
			sql = "SELECT room_Id,room_Price FROM T_Room WHERE room_id = '"
					+ id + "'";
		}
		try {
			conn = dataSource.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				RoomVO roomVo = new RoomVO();
				String roomId = rs.getString("room_id");
				Float price = rs.getFloat("room_price");
				roomVo.setRoomId(roomId);
				roomVo.setPrice(price);
				list.add(roomVo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	
	public RoomVO findRoomByRoomId(String roomid) {
		// TODO Auto-generated method stub
		ArrayList<RoomVO> list = new ArrayList<RoomVO>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		//1 表示 查询所有的可用房间
		//2 表示 按房间Id 查询具体的房间
		
		String	sql = "SELECT * FROM T_Room WHERE room_id = '"+ roomid + "'";
		System.out.println("findRoomByRoomId:---" + sql);
		try {
			conn = dataSource.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			RoomVO roomvo = new RoomVO();
			if (rs.next()) {
				
			   	roomvo.setRoomId(rs.getString("room_Id"));
			   	roomvo.setStatus(rs.getString("room_Status"));
			   	roomvo.setRoomName(rs.getString("room_Name"));
			   	roomvo.setAvailable(rs.getString("room_Available"));
			   	roomvo.setPrice(rs.getFloat("room_Price"));
			   	roomvo.setDiscountPrice(rs.getFloat("room_DiscoutPrice"));
			   	roomvo.setHotelId(rs.getString("room_hotelId"));
			   	
			}
			return roomvo;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public List getPage(int firstRow, int maxRow) {
		// TODO Auto-generated method stub
		String sql = "select * from t_room";
		   Connection conn = null;
		   PreparedStatement pstmt = null;
		   try{
			   System.out.println("login sql=" + sql);
			   conn = dataSource.getConnection();
			   pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			   pstmt.setMaxRows(firstRow+maxRow);
			   ResultSet rs = pstmt.executeQuery();
			   rs.first();
			   rs.relative(firstRow);
			   
			   List<RoomVO> rooms = new ArrayList<RoomVO>();
			   
			   do{		   
				   	RoomVO roomvo = new RoomVO();
				   	roomvo.setRoomId(rs.getString("room_Id"));
				   	roomvo.setStatus(rs.getString("room_Status"));
				   	roomvo.setRoomName(rs.getString("room_Name"));
				   	roomvo.setAvailable(rs.getString("room_Available"));
				   	roomvo.setPrice(rs.getFloat("room_Price"));
				   	roomvo.setDiscountPrice(rs.getFloat("room_DiscoutPrice"));
				   	roomvo.setHotelId(rs.getString("room_hotelId"));
				   	rooms.add(roomvo);
			   }while(rs.next());
			   return rooms;
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

	public int getTotalRows()
	{
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(room_id) FROM T_Room";
				
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
	
	public static void main(String[] args)
	{
		//测试 。。。。。一切正常
		RoomDaoImpl roomDao = new RoomDaoImpl();
		ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");    
		DataSource dataSource = (DataSource)ctx.getBean("dataSource"); 
		roomDao.setDataSource(dataSource);
		System.out.println("rowCount ==" + roomDao.getTotalRows());
		Pager pager = roomDao.getPageData(1,1);
		
		System.out.println(pager.getData().size());
	}
	
}
