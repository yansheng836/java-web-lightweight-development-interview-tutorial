package com.spring;


import com.model.UserInfo;
import com.service.HelloWorldService;

public class HelloWorldAction {
	private String message;
	private HelloWorldService hws;

	private String userName;
	private String userPwd;
	
	public String login() {
		
		UserInfo user = hws.getUserInfoByLoginName(userName,userPwd);
		
		if(user !=null)
		{
    		message = user.getUsername();
    		return "success";
		}
		else 
			return "failure"; 
	}	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getMessage() {
		return message;
	}

	public HelloWorldService getHws() {
		return hws;
	}

	public void setHws(HelloWorldService hws) {
		this.hws = hws;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
