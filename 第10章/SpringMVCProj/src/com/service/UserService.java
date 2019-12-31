package com.service;

import java.util.List;  

import javax.annotation.Resource;


import com.dao.UserDao;
import com.model.User;

  
public class UserService {  
	@Resource(name="userDao")  
    private UserDao userDao;  
  
    public void setUserDao(UserDao userDao) {  
        this.userDao = userDao;  
    }  
  
     
    public void addUser(User user) {  
        userDao.addUser(user);  
    }  
  
    
    public List<User> getAll() {  
        return userDao.getAll();  
    }  
  
 
    public void deleteUser(String id) {  
        userDao.deleteUser(id);  
    }  
  
 
    public User getUser(String id) {  
        return userDao.getUser(id);  
    }  
  
    public void modifyUser(User user) {  
        userDao.modifyUser(user);  
    }  
  
}  