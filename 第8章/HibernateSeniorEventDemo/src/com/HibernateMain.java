package com;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

import Model.UserInfo;

public class HibernateMain {
	public static void main(String[] args) {
		Configuration cfg = null;
		SessionFactory sessionFactory = null;
		
		try
		{
			cfg = new Configuration().configure();	
			sessionFactory = cfg.buildSessionFactory();
		}
		catch (Throwable e)
		{
			throw new ExceptionInInitializerError(e);
		}
        
        
		Session session = sessionFactory.openSession();
		
        Transaction tx = session.beginTransaction();;
		UserInfo user = new UserInfo();
		user.setUserID(3);
		user.setUserName("Peter");
		user.setPwd("456");
		user.setUserType("Vip");
   
        try{        	
        	session.saveOrUpdate(user);
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
		
		user.setUserName("Mike");
		session.update(user);
		session.flush();
		
		session.delete(user);
		session.flush();
		
		session.close();
		sessionFactory.close(); 
   
	}
}
