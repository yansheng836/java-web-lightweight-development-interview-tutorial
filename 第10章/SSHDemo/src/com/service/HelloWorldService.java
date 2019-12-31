package com.service;

import com.dao.UserInfoDao;
import com.model.UserInfo;



public class HelloWorldService {
	
	private UserInfoDao userInfoDao;

	public UserInfo getUserInfoByLoginName(String loginName,String pwd) {
		return userInfoDao.getUserInfoByLoginName(loginName,pwd);
	}
	
	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}
}
