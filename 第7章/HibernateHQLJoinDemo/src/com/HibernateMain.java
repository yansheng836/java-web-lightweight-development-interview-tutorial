package com;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


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
        
        //1 关联查询        
        List<Object[]> list = (List<Object[]>)session.createQuery("select acc.name,acc.bank,acc.balance,u.userType from Account acc, UserInfo u where acc.ID=u.userID").list();

        for(int i=0;i<list.size();i++)
        {
        	Object[] one = list.get(i);
        	System.out.println(one[0] + "\t" + one[1] + "\t" + one[2] + "\t" + one[3]);
        }
        
        //2 子查询
        List<Object[]> groupbyDemoList = (List<Object[]>)session.createQuery("select name,bank,balance from Account where ID in (select userID from UserInfo)").list();
        
        for(int i=0;i<groupbyDemoList.size();i++)
        {
        	Object[] one = groupbyDemoList.get(i);
        	System.out.println(one[0] + "\t" + one[1]  + "\t" + one[2]);
        }
        
        session.close();
		sessionFactory.close(); 
   
	}
}
