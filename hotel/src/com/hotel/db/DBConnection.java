package com.hotel.db;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBConnection {

	
	private static final String driver = "com.mysql.jdbc.Driver";

	private static final String URL = "jdbc:mysql://localhost:3306/hotelmanager?useUnicode=true&characterEncoding=UTF-8";

	private static final String username = "root";

	private static final String password = "root";

	private static Connection conn = null;

	private static DBConnection dbconn = null;

	public static DBConnection getInstatnce() {

		if (dbconn == null) {
			dbconn = new DBConnection();
		}
		return dbconn;
	}

	
	public static synchronized Connection getConnection() throws Exception {

		try {
			
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx
					.lookup("java:com/hotel/db/jdbc/hotel");

			conn = ds.getConnection();
		} catch (NamingException e) {
			
			try {
				Class.forName(driver).newInstance();
				conn = DriverManager.getConnection(URL, username, password);

			} catch (ClassNotFoundException ex) {
				System.out.println("" + ex.getMessage());
			}
		}
		return conn;
	}

	
	public static void closeConnection(Connection conn, PreparedStatement pstmt) {

		try {

			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (conn != null || !conn.isClosed()) {
				conn.close();
				conn = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void closeConnection(Connection conn, PreparedStatement pstmt,
			ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (conn != null || !conn.isClosed()) {
				conn.close();
				conn = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void closeConnection(Connection conn, Statement st) {

		try {
			if (st != null) {
				st.close();
				st = null;
			}
			if (conn != null || !conn.isClosed()) {
				conn.close();
				conn = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void closeConnection(Connection conn, Statement st,
			ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (st != null) {
				st.close();
				st = null;
			}
			if (conn != null || !conn.isClosed()) {
				conn.close();
				conn = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		try {
			conn = DBConnection.getConnection();
			if (conn != null) {
				System.out.println("Connection is OK....");
			} else {
				System.out.println("Connection is NO....");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (!conn.isClosed() || conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
