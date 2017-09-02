package com.nagarro.struts.hrmanager.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginManagerAction extends ActionSupport implements SessionAware {
	private String username;
	private String password;
	private Map<String, Object> sessionMap;

	public String execute() {
		 String loggedUserName = null;
		 String retVal = null;
		// check if the userName is already stored in the session
	    if (sessionMap.containsKey("username")) {
	        loggedUserName = (String) sessionMap.get("username");
	    }
	    /*else{
	    	retVal = ActionSupport.INPUT;
	    }*/
	    if (loggedUserName != null && loggedUserName.equals("admin")) {
	        return ActionSupport.SUCCESS; // return welcome page
	    }
	     
	    // if no userName stored in the session,
	    // check the entered userName and password
	    if (username != null && username.equals("admin")
	            && password != null && password.equals("pass")) {
	         
	        // add userName to the session
	        sessionMap.put("username", username);
	         
	        retVal = ActionSupport.SUCCESS; // return welcome page
	    }
	    else {
			addActionError(getText("error.login"));
			retVal = ActionSupport.INPUT;
		}
	     
	  	return retVal;

	}
	public String logout() {
	    // remove userName from the session
	    if (sessionMap.containsKey("username")) {
	        sessionMap.remove("username");
	    }
	    return ActionSupport.SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
	    this.sessionMap = sessionMap;
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


 