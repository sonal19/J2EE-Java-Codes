package com.nagarro.imageutility.models;

import java.io.Serializable;

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
@Table(name = "Image_Details")
public class ImageDetail implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The user id. */
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

	/** The image stream. */
	@Column(columnDefinition = "LONGBLOB")
	private byte[] imageStream;

	/**
	 * The register detail id the register class object for many to one mapping.
	 */
	@ManyToOne
	@JoinColumn(name = "registerDetail")
	private RegisterDetail registerDetail;

	/**
	 * Gets the register detail.
	 *
	 * @return the register detail
	 */
	public RegisterDetail getRegisterDetail() {
		return registerDetail;
	}

	/**
	 * Sets the register detail.
	 *
	 * @param registerDetail
	 *            the new register detail
	 */
	public void setRegisterDetail(final RegisterDetail registerDetail) {
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
	public void setName(final String name) {
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
	public void setSize(final double size) {
		this.size = size;
	}

	/**
	 * Gets the image stream.
	 *
	 * @return the image stream
	 */
	public byte[] getImageStream() {
		return imageStream;
	}

	/**
	 * Sets the image stream.
	 *
	 * @param imageStream
	 *            the new image stream
	 */
	public void setImageStream(final byte[] imageStream) {
		this.imageStream = imageStream;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId
	 *            the new user id
	 */
	public void setUserId(final int userId) {
		this.userId = userId;
	}

}
