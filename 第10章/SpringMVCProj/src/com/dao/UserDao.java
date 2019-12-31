package com.dao;

import java.util.List;  

import org.hibernate.Query;  
import org.hibernate.SessionFactory;

import com.model.User;
  
  
public class UserDao {  
    private SessionFactory sessionFactory;  
      
    public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    }  
  
     
    public void addUser(User user) {  
        sessionFactory.getCurrentSession().save(user);  
    }  
  
      
    public void deleteUser(String id) {  
        String hql = "delete from User where id=?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setString(0, id);  
        query.executeUpdate();  
    }  
  
    public List<User> getAll() {  
        String hql = "from User";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        return query.list();  
    }  
  
    public User getUser(String id) {  
        String hql = "from User where id=?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setString(0, id);  
        return (User) query.uniqueResult();  
    }  
  
    public void modifyUser(User user) {  
        String hql = "update User set name=?,age=? where id=?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setString(0, user.getName());  
        query.setInteger(1, user.getAge());  
        query.setInteger(2, user.getId());  
        query.executeUpdate();  
    }
}  