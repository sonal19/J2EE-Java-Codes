package com.nagarro.struts.hrmanager.actions;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginManagerAction extends ActionSupport {
	private String username;
	private String password;

	public String execute() {
		String retVal = null;
		if (this.username.equals("admin") && this.password.equals("password")) {
			retVal = ActionSupport.SUCCESS;
		} else {
			addActionError(getText("error.login"));
			retVal = ActionSupport.ERROR;
		}
		return retVal;

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
