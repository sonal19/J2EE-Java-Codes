package com.nagarro.imageutility.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The Class RegisterDetail keeps the user details who are signing up for the
 * application.
 */
@Entity
@Table(name = "Registration_Details",uniqueConstraints = {
		@UniqueConstraint(columnNames = { "userName","email" }) })
public class RegisterDetail {

	/**
	 * The user id is the unique Id which uniquely identify the user in the
	 * given table.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int userId;

	/**
	 * The full name gives the complete name of the user who are going to use
	 * the application.
	 */
	private String fullName;

	
	/** The email is the email id of the registered user. */
	private String email;

	/**
	 * The user name is defined by the user and it is used for login into the
	 * Application.
	 */
	private String userName;

	/**
	 * The password for secure login for the particular user from the database.
	 */
	private String password;

	@SuppressWarnings("rawtypes")
	@OneToMany(targetEntity = ImageDetail.class, mappedBy = "registerDetail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List imageList;
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@SuppressWarnings("rawtypes")
	public List getImageList() {
		return imageList;
	}

	@SuppressWarnings("rawtypes")
	public void setImageList(List imageList) {
		this.imageList = imageList;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return userId;
	}

	/**
	 * Sets the id.
	 *
	 * @param userId
	 *            the new id
	 */
	public void setId(final int userId) {
		this.userId = userId;
	}

	/**
	 * Gets the full name.
	 *
	 * @return the full name
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Sets the full name.
	 *
	 * @param fullName
	 *            the new full name
	 */
	public void setFullName(final String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the new email
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName
	 *            the new user name
	 */
	public void setUserName(final String userName) {
		this.userName = userName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the new password
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

}
