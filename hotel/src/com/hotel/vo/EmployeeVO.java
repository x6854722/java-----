package com.hotel.vo;

/**
 * <p>
 * Title: HM System
 * </p>
 * 
 * <p>
 * Description: ��Ա��ϢBEAN
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
 * @createDate 2009-5-1 ����00:11:40
 * @updateDate
 * @updateDes
 */
public class EmployeeVO {

	/**
	 * Ա��Id
	 */
	private String empid = "";

	/**
	 * ����
	 */
	private String password = "";

	/**
	 * ����
	 */
	private String empName = "";

	/**
	 * �Ա�
	 */
	private String sex;

	/**
	 * Ȩ��
	 */
	private String purview = "";

	/**
	 * �绰
	 */
	private String position = "";

	public String getEmpid() {

		return empid;
	}

	/**
	 * 
	 * @param empid
	 */
	public void setEmpid(String empid) {

		this.empid = empid;
	}

	public String getPassword() {

		return password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {

		this.password = password;
	}

	public String getEmpName() {

		return empName;
	}

	/**
	 * 
	 * @param empName
	 */
	public void setEmpName(String empName) {

		this.empName = empName;
	}

	/**
	 * 
	 * @return
	 */
	public String getSex() {

		return sex;
	}

	/**
	 * 
	 * @param sex
	 */
	public void setSex(String sex) {

		this.sex = sex;
	}

	public String getPurview() {

		return purview;
	}

	/**
	 * 
	 * @param purview
	 */
	public void setPurview(String purview) {

		this.purview = purview;
	}

	public String getPosition() {

		return position;
	}

	/**
	 * 
	 * @param position
	 */
	public void setPosition(String position) {

		this.position = position;
	}

}
