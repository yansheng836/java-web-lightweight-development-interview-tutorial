package com;

import interceptor.UserInfoInterceptor;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;

import Model.UserInfo;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateMain {
	public static void main(String[] args) {
		UserInfoInterceptor interceptor = new UserInfoInterceptor();
		Configuration cfg = null;
		SessionFactory sessionFactory = null;
		
		try
		{
			cfg = new Configuration().configure();
			 
			sessionFactory = cfg.setInterceptor(interceptor).buildSessionFactory();
		}
		catch (Throwable e)
		{
			throw new ExceptionInInitializerError(e);
		}
        
        //Session session = sessionFactory.withOptions().interceptor(interceptor).openSession();
		Session session = sessionFactory.openSession();
		
        Transaction tx = session.beginTransaction();;
		UserInfo user = new UserInfo();
		user.setUserID(3);
		user.setUserName("Peter");
		user.setPwd("456");
		user.setUserType("Vip");
   
        try{        	
        	session.save(user);
            tx.commit();	
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	tx.rollback();
        }

		List<UserInfo> users = new ArrayList<UserInfo>();
		String hqlstr = "from Model.UserInfo";
		Query query = session.createQuery(hqlstr);
		users = query.list(); 
		System.out.println("users size is:" + users.size());
		System.out.println("UserName" + "\t" + "UserType");
		for(UserInfo u : users){
			System.out.println(u.getUserName() + "\t" + u.getUserType());
		}
		
		session.delete(user);
		session.flush();
		
		session.close();
		sessionFactory.close(); 
   
	}
}
