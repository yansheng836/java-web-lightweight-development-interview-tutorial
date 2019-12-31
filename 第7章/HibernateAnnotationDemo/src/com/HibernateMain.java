package com;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Model.UserInfo;

public class HibernateMain {
	public static void main(String[] args) {
		
		StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        try{
            registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            //不指定文件名默认是找hibernate.cfg.xml文件
            //registry = new StandardServiceRegistryBuilder().configure().build(); 
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }catch(Exception ex){
            ex.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
        
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
		session.close();
		sessionFactory.close(); 
   
	}
}
