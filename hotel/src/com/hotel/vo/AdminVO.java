package com.hotel.vo;

/**
 * <p>
 * Title: HM System
 * </p>
 * 
 * <p>
 * Description: ����Ա��Ϣ BEAN
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2009
 * </p>
 * 
 * <p>
 * Company: 
 * </p> ��
 * <p>
 * Author: tjy
 * </p>
 * 
 * @version 1.0
 * @createDate 2009-4-26 ����03:11:40
 * @updateDate
 * @updateDes
 */
public class AdminVO {

	/**
	 * �û���
	 */
	private String userName = "";

	/**
	 * �û�����
	 */
	private String password = "";

	/**
	 * �û���ɫ
	 */
	private Integer role;

	/**
	 * ��ע
	 */
	private String remark = "";

	public String getUserName() {

		return userName;
	}

	/**
	 * 
	 * @param userName
	 *            �û���
	 */
	public void setUserName(String userName) {

		this.userName = userName;
	}

	public String getPassword() {

		return password;
	}

	/**
	 * 
	 * @param password
	 *            ����
	 */
	public void setPassword(String password) {

		this.password = password;
	}

	public Integer getRole() {

		return role;
	}

	/**
	 * 
	 * @param role
	 *            ��ɫ
	 */
	public void setRole(Integer role) {

		this.role = role;
	}

	public String getRemark() {

		return remark;
	}

	/**
	 * 
	 * @param remark
	 *            ��ע
	 */
	public void setRemark(String remark) {

		this.remark = remark;
	}

}
