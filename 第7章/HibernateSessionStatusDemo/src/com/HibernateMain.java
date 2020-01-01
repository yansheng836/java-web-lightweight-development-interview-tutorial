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

import Model.Account;

public class HibernateMain {
	public static void main(String[] args) {
		
		StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        try{
            registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }catch(Exception ex){
            ex.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
        
        Session session = sessionFactory.openSession();
        //演示update和merge以及saveOrUpdate的差别
        Transaction tx = session.beginTransaction();
        Account peterAcc = new Account();
        peterAcc.setName("Peter");
        peterAcc.setBank("PeterBank");
        peterAcc.setBalance(200);
        //session.update(peterAcc); error
        session.merge(peterAcc);  //ok
        session.saveOrUpdate(peterAcc);  //ok
        tx.commit();
        //演示save和persist的差别
        tx = session.beginTransaction();
        Account mikeAcc = new Account();
        mikeAcc.setName("Mike");
        mikeAcc.setBank("MikeBank");
        mikeAcc.setBalance(300.0f);
        System.out.println("the new inserted id is:" + session.save(mikeAcc));
        //persist方法没有返回类型
        session.persist(mikeAcc);
        tx.commit();        
        //演示flush的用法
        Account flushAcc = new Account();
        flushAcc.setName("Flush");
        flushAcc.setBank("FlushBank");
        flushAcc.setBalance(1000);
        session.save(flushAcc);
        session.flush();
        flushAcc.setBalance(2000);
        
        //演示evict和clear
//        Account evictAcc = new Account();
//        evictAcc.setName("Evict");
//        evictAcc.setBank("EvictBank");
//        evictAcc.setBalance(1000);
//        session.save(evictAcc);
//        //session.evict(evictAcc);// error
//        session.clear();
//        session.flush();
        //关闭必要的对象
        session.close();
		sessionFactory.close(); 
   
	}
}
