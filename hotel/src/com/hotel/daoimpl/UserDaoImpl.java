package com.hotel.daoimpl;

import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import com.hotel.dao.UserDAO;
import com.hotel.db.DBConnection;
import com.hotel.tool.Pager;
import com.hotel.vo.ReserveVO;
import com.hotel.vo.UserVO;

@Component("userdao")
public class UserDaoImpl implements UserDAO{

	private DataSource dataSource;

	public boolean insertUser(UserVO userVo) {
		// TODO Auto-generated method stub
		if (userVo == null || userVo.equals("")) {
			return false;
		}
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO T_User(user_id,user_pwd,user_name,user_age,user_sex,user_mobile,user_email,user_certitype,user_certinum,user_address,user_level,user_point,user_birthday) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {

			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userVo.getUserId());
			pstmt.setString(2, userVo.getUserPassword());
			pstmt.setString(3, userVo.getUserName());
			pstmt.setInt(4, userVo.getAge());
			pstmt.setString(5, userVo.getSex());
			pstmt.setString(6, userVo.getMobile());
			pstmt.setString(7, userVo.getEmail());
			pstmt.setString(8, userVo.getCertiType());
			pstmt.setString(9, userVo.getCertiNum());
			pstmt.setString(10, userVo.getAddress());
			pstmt.setInt(11, 0);
			pstmt.setInt(12, 0);
			pstmt.setString(13, userVo.getBirthday());

			System.out.println("insertUser sql=" + sql);

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
	
	
	public boolean logUser(UserVO uservo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(user_id) FROM T_User WHERE user_id = '"
				+ uservo.getUserId() + "' AND user_pwd = '" + uservo.getUserPassword() + "'";
		try {
			System.out.println("login sql=" + sql);
			conn = dataSource.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			rs.next();
			int i = rs.getInt(1);
			if (i > 0) {
				System.out.println("i " + i);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return false;
	}
	public UserVO findUserById(String userId) {
		// TODO Auto-generated method stub
				
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM T_User WHERE user_Id='" + userId+"'";
				
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			System.out.println("findAdminById sql=" + sql);
			rs = pstmt.executeQuery();
			rs.next();
			
			UserVO uservo = new  UserVO();
			uservo.setUserId(rs.getString("user_id"));
			uservo.setUserName(rs.getString("user_name"));
			uservo.setUserPassword(rs.getString("user_pwd"));
			uservo.setAge(rs.getInt("user_age"));
			uservo.setSex(rs.getString("user_sex"));
			uservo.setMobile(rs.getString("user_mobile"));
			uservo.setEmail(rs.getString("user_email"));
			uservo.setCertiType(rs.getString("user_certitype"));
			uservo.setCertiNum(rs.getString("user_certinum"));
			uservo.setAddress(rs.getString("user_address"));
			uservo.setLevel(rs.getInt("user_level"));
			uservo.setPoint(rs.getInt("user_point"));
			uservo.setBirthday(rs.getString("user_birthday"));
			
			return uservo;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, pstmt, rs);
		}
	
		return null;
	}
	/**
	 * 查看用户的订单
	 */
	public List getPageData(String userId, int firstRow, int maxRow,
			String serchType) {
		// TODO Auto-generated method stub
	   
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   String sql = "select * from t_reserve where reserve_userid='"+userId+"'";
	   if(serchType.equals("success"))
	   {
		   sql = "select * from t_reserve where reserve_userid='"+userId
				   +"'  and  reserve_needchk='成功'";
	   }else if(serchType.equals("needchk"))
	   {
		   sql = "select * from t_reserve where reserve_userid='"+userId
				   +"'  and  reserve_needchk='需要审查'";
	   }
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
		   try{
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
		   }catch (Exception e) {
			// TODO: handle exception
			   System.out.println(" 结果集为空");
		   }
		   
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


	public Pager getReservePageData(String userId,int pageSize, int pageNow,String serchType) {
		// TODO Auto-generated method stub
		int rowCount = getTotalRows(userId,serchType);
		
		if(pageSize <= 0 )
		{
			pageSize=5;
		}
		Pager pager = new Pager(pageSize,pageNow,rowCount);
		pager.setData(getPageData(userId,(pager.getPagenow()-1)*pager.getPageSize(),pager.getPageSize(),serchType));
		return pager;
	}


	public int getTotalRows(String userId,String serchType) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(reserve_id) FROM T_Reserve where reserve_userId='"+userId 
				+"'  and reserve_needchk='" + serchType+"'";
				
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
	
	
	public List getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	

	public DataSource getDataSource() {
		return dataSource;
	}
	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public static void main(String[] args){
		UserVO uservo = new UserVO();
		uservo.setUserName("周亮");
		UserDAO userDao = new UserDaoImpl();
		userDao.insertUser(uservo);
		
		uservo = userDao.findUserById("smilethat");
		System.out.println("user infos" + uservo);
	}


	


	

}
