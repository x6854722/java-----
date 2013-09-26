package com.hotel.vo;


public class UserVO {

	private String userId = "";

	
	private String userPassword = "";

	
	private String userName = "";

	
	private String sex = "";

	
	private String mobile = "";

	
	private String email = "";

	
	private String certiType = "";

	
	private String certiNum = "";

	
	private String address = "";

	
	private String applyTime = "";

	
	private String birthday = "";

	
	private int age;

	
	private int level;

	
	private int point;

	
	public String getUserId() {

		return userId;
	}

	/**
	 * 
	 * @param userId
	 */
	public void setUserId(String userId) {

		this.userId = userId;
	}

	/**
	 * 
	 * @return the userPassword
	 */
	public String getUserPassword() {

		return userPassword;
	}

	/**
	 * 
	 * @param userPassword
	 */
	public void setUserPassword(String userPassword) {

		this.userPassword = userPassword;
	}

	/**
	 * 
	 * @return the userName
	 */
	public String getUserName() {

		return userName;
	}

	/**
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {

		this.userName = userName;
	}

	/**
	 * 
	 * @return the sex
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

	/**
	 * 
	 * @return the mobile
	 */
	public String getMobile() {

		return mobile;
	}

	/**
	 * 
	 * @param mobile
	 */
	public void setMobile(String mobile) {

		this.mobile = mobile;
	}

	/**
	 * 
	 * @return the email
	 */
	public String getEmail() {

		return email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {

		this.email = email;
	}

	/**
	 * 
	 * @return the certiType
	 */
	public String getCertiType() {

		return certiType;
	}

	/**
	 * 
	 * @param certiType
	 */
	public void setCertiType(String certiType) {

		this.certiType = certiType;
	}

	/**
	 * 
	 * @return the certiNum
	 */
	public String getCertiNum() {

		return certiNum;
	}

	/**
	 * 
	 * @param certiNum
	 */
	public void setCertiNum(String certiNum) {

		this.certiNum = certiNum;
	}

	/**
	 * 
	 * @return the address
	 */
	public String getAddress() {

		return address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {

		this.address = address;
	}

	/**
	 * 
	 * @return the applyTime
	 */
	public String getApplyTime() {

		return applyTime;
	}

	/**
	 * 
	 * @param applyTime
	 */
	public void setApplyTime(String applyTime) {

		this.applyTime = applyTime;
	}

	/**
	 * 
	 * @return the age
	 */
	public int getAge() {

		return age;
	}

	/**
	 * 
	 * @param age
	 */
	public void setAge(int age) {

		this.age = age;
	}

	/**
	 * 
	 * @return the level
	 */
	public int getLevel() {

		return level;
	}

	/**
	 * 
	 * @param level
	 */
	public void setLevel(int level) {

		this.level = level;
	}

	/**
	 * 
	 * @return the point
	 */
	public int getPoint() {

		return point;
	}

	/**
	 * 
	 * @param point
	 */
	public void setPoint(int point) {

		this.point = point;
	}

	/**
	 * 
	 * @return the birthday
	 */
	public String getBirthday() {

		return birthday;
	}

	/**
	 * 
	 * @param birthday
	 */
	public void setBirthday(String birthday) {

		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPassword=" + userPassword
				+ ", userName=" + userName + ", sex=" + sex + ", mobile="
				+ mobile + ", email=" + email + ", certiType=" + certiType
				+ ", certiNum=" + certiNum + ", address=" + address
				+ ", applyTime=" + applyTime + ", birthday=" + birthday
				+ ", age=" + age + ", level=" + level + ", point=" + point
				+ "]";
	}

}
