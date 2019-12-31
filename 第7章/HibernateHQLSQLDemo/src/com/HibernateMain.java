package com;


import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        
        //1 执行SQL        
        SQLQuery query = session.createSQLQuery("select id,name,bank,balance from account where ID = ?");
         //设置第一个参数的值为1,即查询ID=1的account
        query.setParameter(0, 1);
        List<Object[]> list = query.list();
        
        for(int i=0;i<list.size();i++)
        {
        	Object[] one = list.get(i);
        	System.out.println(one[0] + "\t" + one[1]  + "\t" + one[2] + "\t" + one[3]);
        }
        
        //2 实体查询
        query = session.createSQLQuery("select id,name,bank,balance from account where id = ?").addEntity(Account.class);
        query.setParameter(0, 1);
        List<Account> accList = query.list();
        for(int i=0;i<accList.size();i++)
        {
        	Account one = accList.get(i);
        	System.out.println(one.getID() + "\t" + one.getName()  + "\t" + one.getBank() + "\t" + one.getBalance());
        }
        
        //3 执行更新
        query = session.createSQLQuery("update  Account set balance = ? where id = ?");
        query.setFloat(0, 2000f);
        query.setInteger(1, 1);
        query.executeUpdate();
         
        session.close();
		sessionFactory.close(); 
   
	}
}
