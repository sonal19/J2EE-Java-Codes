package com.nagarro.imageutility.models;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginDetail for login the user in the application for uploading the
 * Image and remaining functioning.
 */
public class LoginDetail {

	/**
	 * The user name is defined by the user and it is used for login into the
	 * Application.
	 */
	private String userName;

	/**
	 * The password for secure login for the particular user from the database.
	 */
	private String password;

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
	public void setUserName(String userName) {
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
	public void setPassword(String password) {
		this.password = password;
	}
}
