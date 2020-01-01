package com;


import java.util.List;

import net.sf.ehcache.config.DiskStoreConfiguration;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import Model.Account;


public class HibernateMain {
	public static void main(String[] args) {
		
		
		
		Configuration configuration = new Configuration();  
		
		  
        try {  
            configuration.configure();  
        } catch (HibernateException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
              
          
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();  
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
        
        Session session = sessionFactory.openSession();
        
        Transaction tr1 = session.beginTransaction();  
        //加载ID为1的对象  
        Account acc1 = (Account) session.get(Account.class, 1);  
        System.out.println("In First Session, name is "+ acc1.getName());  
        tr1.commit();  
        session.close();  
          
        //加载ID同样是1的对象  
        Session session2 = sessionFactory.openSession();  
        Transaction tr2 = session2.beginTransaction();  
        Account acc2 = (Account) session2.get(Account.class, 1);    
        System.out.println("In Another Session, name is  "+acc2.getName());  
        tr2.commit();  
        session2.close();  
        
       
        sessionFactory.close(); 
   
	}
}
