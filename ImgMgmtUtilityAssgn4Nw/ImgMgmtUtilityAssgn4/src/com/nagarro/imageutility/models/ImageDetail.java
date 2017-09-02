package com.nagarro.imageutility.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The Class ImageDetail contains the details of the image like its
 * size,name,path and used to upload the image in the we application.
 */
@Entity
@Table(name="Image_Details")
public class ImageDetail {

	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int userId;
	/**
	 * The name is the name of the image that is uploaded or browsed by the
	 * user.
	 */
	private String name;

	/** The size is the size of uploaded image in the application. */
	private double size;

	/**
	 * 
	 */
	@Column(columnDefinition = "LONGBLOB") 
	private byte[] imageStream;

	
	@ManyToOne
	@JoinColumn(name = "registerDetail")
	private RegisterDetail registerDetail;
	
	public RegisterDetail getRegisterDetail() {
		return registerDetail;
	}

	public void setRegisterDetail(RegisterDetail registerDetail) {
		this.registerDetail = registerDetail;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public double getSize() {
		return size;
	}

	/**
	 * Sets the size.
	 *
	 * @param size
	 *            the new size
	 */
	public void setSize(double size) {
		this.size = size;
	}

	public byte[] getImageStream() {
		return imageStream;
	}

	public void setImageStream(byte[] imageStream) {
		this.imageStream = imageStream;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
