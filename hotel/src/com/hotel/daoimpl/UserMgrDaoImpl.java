package com.hotel.daoimpl;


import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.hotel.dao.UserMgrDAO;
import com.hotel.db.DBConnection;
import com.hotel.tool.Pager;
import com.hotel.vo.UserVO;

@Component("usermgrDao")
public class UserMgrDaoImpl implements UserMgrDAO {

	private DataSource dataSource;
	public List<UserVO> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

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
	public  List getPage(int firstrow,int  maxRow) {
	               //String queryString = "from Product";
	   //String sql="from Product";
	   String sql = "select * from t_user";
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   try{
		   System.out.println("login sql=" + sql);
		   conn = dataSource.getConnection();
		   pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		   pstmt.setMaxRows(firstrow+maxRow);
		   ResultSet rs = pstmt.executeQuery();
		   rs.first();
		   rs.relative(firstrow);
		   
		   List<UserVO> users = new ArrayList<UserVO>();
		   
		   do{		   
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
				users.add(uservo);
		   }while(rs.next());
		   return users;
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
		String sql = "SELECT COUNT(user_id) FROM T_User";
				
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
	public boolean isExist(String user_id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(user_id) FROM T_User WHERE user_id = '"+user_id+ "'";
		try {
			System.out.println("login sql=" + sql);
			conn = dataSource.getConnection();
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

		}
		return false;
	}

	public boolean deleteUser(String user_id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "DELETE FROM T_User WHERE user_id = '"+user_id+ "'";
		try {
			System.out.println("login sql=" + sql);
			conn = dataSource.getConnection();
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

		}
		return false;
	}
	
	public boolean chkpwd(String userId, String pwd) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "UPDATE T_User SET user_pwd = '" + pwd 
				+ "'  WHERE user_Id = '" + userId + "'";
		try {
			System.out.println("login sql=" + sql);
			conn = dataSource.getConnection();
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

		}
		return false;
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
		
		UserMgrDaoImpl usermgrDao = new UserMgrDaoImpl();
		ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");    
		DataSource dataSource = (DataSource)ctx.getBean("dataSource"); 
		usermgrDao.setDataSource(dataSource);
		System.out.println("rowCount ==" + usermgrDao.getTotalRows());
		Pager pager = usermgrDao.getPageData(5,2);
		
		System.out.println(pager.getData().size());
	}

	

	

	

}
