package com.hotel.vo;

public class ReserveVO {

	
	private String reserveId;

	
	private String roomId;

	
	private String hotelId;

	
	private String userId;

	
	private int quantity;

	
	private int people;

	
	private float price;

	
	private float total;

	
	private String startTime;

	
	private String overTime;

	
	private String status;

	
	private String needchk;
	public String getReserveId() {

		return reserveId;
	}

	/**
	 * 
	 * @param reserveId
	 */
	public void setReserveId(String reserveId) {

		this.reserveId = reserveId;
	}

	public String getRoomId() {

		return roomId;
	}

	/**
	 * 
	 * @param roomId
	 */
	public void setRoomId(String roomId) {

		this.roomId = roomId;
	}

	public String getHotelId() {

		return hotelId;
	}

	/**
	 * 
	 * @param hotelId
	 */
	public void setHotelId(String hotelId) {

		this.hotelId = hotelId;
	}

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

	public int getQuantity() {

		return quantity;
	}

	/**
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {

		this.quantity = quantity;
	}

	public int getPeople() {

		return people;
	}

	/**
	 * 
	 * @param people
	 */
	public void setPeople(int people) {

		this.people = people;
	}

	public float getPrice() {

		return price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(float price) {

		this.price = price;
	}

	public float getTotal() {

		return total;
	}

	/**
	 * 
	 * @param total
	 */
	public void setTotal(float total) {

		this.total = total;
	}

	public String getStartTime() {

		return startTime;
	}

	/**
	 * 
	 * @param startTime
	 */
	public void setStartTime(String startTime) {

		this.startTime = startTime;
	}

	public String getOverTime() {

		return overTime;
	}

	/**
	 * 
	 * @param overTime
	 */
	public void setOverTime(String overTime) {

		this.overTime = overTime;
	}

	public String getStatus() {

		return status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(String status) {

		this.status = status;
	}

	public String getNeedchk() {
		return needchk;
	}

	public void setNeedchk(String needchk) {
		this.needchk = needchk;
	}

	@Override
	public String toString() {
		return "ReserveVO [reserveId=" + reserveId + ", roomId=" + roomId
				+ ", hotelId=" + hotelId + ", userId=" + userId + ", quantity="
				+ quantity + ", people=" + people + ", price=" + price
				+ ", total=" + total + ", startTime=" + startTime
				+ ", overTime=" + overTime + ", status=" + status
				+ ", needchk=" + needchk + "]";
	}

}
