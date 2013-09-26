package com.hotel.vo;

import java.io.File;

/**
 * <p>
 * Title: HM System
 * </p>
 * 
 * <p>
 * Description: �Ƶ���Ϣ BEAN
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
 * @createDate 2009-5-01 ����03:11:40
 * @updateDate
 * @updateDes
 */
public class HotelVO {

	/**
	 * �Ƶ�ID
	 */
	private String hotelId;

	/**
	 * �Ƶ����
	 */
	private String hotelName;

	/**
	 * ����
	 */
	private String star;

	/**
	 * �۸�Χ
	 */
	private float price;

	/**
	 * ��������
	 */
	private int quantity;

	/**
	 * �ص�
	 */
	private String address;

	/**
	 * ��ƷͼƬ���ļ�����
	 */
	private File image;

	/**
	 * ͼƬ����
	 */
	private String imageContentType = "";

	/**
	 * ͼƬ���
	 */

	private String imageFileName = "";

	/**
	 * �Ƶ�˵��
	 */
	private String description;

	/**
	 * �۸�Χ
	 */
	private String priceRange;

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

	public String getHotelName() {

		return hotelName;
	}

	/**
	 * 
	 * @param hotelName
	 */
	public void setHotelName(String hotelName) {

		this.hotelName = hotelName;
	}

	public String getStar() {

		return star;
	}

	/**
	 * 
	 * @param star
	 */
	public void setStar(String star) {

		this.star = star;
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

	public File getImage() {

		return image;
	}

	/**
	 * 
	 * @param image
	 */
	public void setImage(File image) {

		this.image = image;
	}

	public String getImageContentType() {

		return imageContentType;
	}

	/**
	 * 
	 * @param imageContentType
	 */
	public void setImageContentType(String imageContentType) {

		this.imageContentType = imageContentType;
	}

	public String getImageFileName() {

		return imageFileName;
	}

	/**
	 * 
	 * @param imageFileName
	 */
	public void setImageFileName(String imageFileName) {

		this.imageFileName = imageFileName;
	}

	public String getDescription() {

		return description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {

		this.description = description;
	}

	public String getPriceRange() {

		return priceRange;
	}

	/**
	 * 
	 * @param priceRange
	 */
	public void setPriceRange(String priceRange) {

		this.priceRange = priceRange;
	}
}
