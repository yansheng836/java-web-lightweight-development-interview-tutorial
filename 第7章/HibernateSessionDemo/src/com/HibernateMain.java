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
        Transaction tx = session.beginTransaction();
                
        //1 得到Account表里所有记录        
        List<Account> accountList = new ArrayList<Account>();
		String hqlstr = "from Account";
		Query query = session.createQuery(hqlstr);
		accountList = query.list(); 
        //用load方式 
		System.out.println("load...");
//		Account loadNotExistAcc = (Account)session.load(Account.class, 100);
//		if(loadNotExistAcc == null)
//		{
//			System.out.println("loadNotExistAcc is null");
//		}
//		else
//		{
//			loadNotExistAcc.getBank();
//		}
        for(int i = 0;i<accountList.size();i++)
        {
        	Account one = (Account)session.load(Account.class, accountList.get(i).getID());
        	System.out.println(one.getName() + "\t" + one.getBank() + "\t" + one.getBalance());
        }
        //用get方式 
		System.out.println("get...");
		Account getNotExistAcc = (Account)session.get(Account.class, 100);
		if(getNotExistAcc == null)
		{
			System.out.println("getNotExistAcc is null");
		}
		else
		{
			getNotExistAcc.getBank();
		}
        for(int i = 0;i<accountList.size();i++)
        {
        	Account one = (Account)session.get(Account.class, accountList.get(i).getID());
        	System.out.println(one.getName() + "\t" + one.getBank() + "\t" + one.getBalance());
        }
		//delete account one by one
        for(int i = 0;i<accountList.size();i++)
        {
        	int ID = accountList.get(i).getID();
        	System.out.println("delete the Account with ID=" + ID);
        	session.delete(accountList.get(i));
        }
        
        //insert 2 account
        Account accForJava = new Account();
        accForJava.setName("Java");
        accForJava.setBank("JavaBank");
        accForJava.setBalance(100);
        session.save(accForJava);
        
        Account accForORM = new Account();
        accForORM.setName("ORM");
        accForORM.setBank("ORMBank");
        accForORM.setBalance(1000);
        session.save(accForORM);
        tx.commit();
        
        //3 再开启另外一个事务更新数据
        tx = session.beginTransaction();
        accountList = query.list(); 
        //用load方式拿到数据，并给每个账户加200元		
        for(int i = 0;i<accountList.size();i++)
        {
        	Account one = (Account)session.load(Account.class, accountList.get(i).getID());
        	one.setBalance(one.getBalance() + 200);
        	session.update(one);
        }        
        tx.commit();
        
//        
//        
//		Account acc = new Account();
//		
//		acc.setName("Tom");
//		acc.setBank("CitiBank");
//		acc.setBalance(100);
//        try{
//        	
//        	session.save(acc);
//            tx.commit();	
//        }
//        catch(Exception e)
//        {
//        	e.printStackTrace();
//        	tx.rollback();
//        }

        session.close();
		sessionFactory.close(); 
   
	}
}
