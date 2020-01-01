package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import Model.Account;

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
		Account acc = new Account();
		
		acc.setName("Tom");
		acc.setBank("CitiBank");
		acc.setBalance(100);
        try{
        	
        	session.save(acc);
            tx.commit();	
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        	tx.rollback();
        }

        session.close();
		sessionFactory.close(); 
   
	}
}
