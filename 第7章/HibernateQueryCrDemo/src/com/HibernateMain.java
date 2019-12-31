package com;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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
        
        //通过Criteria添加条件
        Criteria crit = session.createCriteria(Account.class);
        crit.add(Restrictions.ge("ID", new Integer(5)));
        crit.add(Restrictions.and( Restrictions.ge("balance", new Float(300f)) ));
        crit.addOrder(Order.asc("name"));
        crit.setMaxResults(2);
        List<Account> accountList = crit.list();

        for(int i=0;i<accountList.size();i++)
        {
        	Account one = accountList.get(i);
        	System.out.println(one.getID() + "\t" + one.getName() + "\t" + one.getBank()  + "\t" + one.getBalance());
        }
        
         //通过group by分组
        List results = session.createCriteria(Account.class)
        		.setProjection( Projections.rowCount() )
        		.list();
        System.out.println(results.get(0));  
        
        
        ProjectionList proList = Projections.projectionList(); 
        proList.add(Projections.rowCount()); 
        proList.add(Projections.max("balance")); 
        proList.add(Projections.sum("balance")); 
        proList.add(Projections.groupProperty("name"));
        crit = session.createCriteria(Account.class);
        crit.setProjection(proList); 
        results = crit.list(); 
         
        for(int  i=0;i<results.size();i++)
        {
        	Object[] arr = (Object[])results.get(i);
        	for(Object ob : arr){ 
                System.out.print(ob.toString() + "\t");   
            }	
        	System.out.println();
        }
         
          
       
       
        
        session.close();
		sessionFactory.close(); 
   
	}
}
