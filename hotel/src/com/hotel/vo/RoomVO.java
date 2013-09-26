package com.hotel.vo;


public class RoomVO {

	
	private String roomId;

	
	private String roomName;

	
	private String status;

	
	private String available;

	
	private float price;

	
	private float discountPrice;

	
	private String hotelId;

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

	public String getRoomName() {

		return roomName;
	}

	/**
	 * 
	 * @param roomName
	 */
	public void setRoomName(String roomName) {

		this.roomName = roomName;
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

	public String getAvailable() {

		return available;
	}

	/**
	 * 
	 * @param available
	 */
	public void setAvailable(String available) {

		this.available = available;
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

	public float getDiscountPrice() {

		return discountPrice;
	}

	/**
	 * 
	 * @param discountPrice
	 */
	public void setDiscountPrice(float discountPrice) {

		this.discountPrice = discountPrice;
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

	@Override
	public String toString() {
		return "RoomVO [roomId=" + roomId + ", roomName=" + roomName
				+ ", status=" + status + ", available=" + available
				+ ", price=" + price + ", discountPrice=" + discountPrice
				+ ", hotelId=" + hotelId + "]";
	}

}
