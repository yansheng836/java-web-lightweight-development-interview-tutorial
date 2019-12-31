package com;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.TransactionStatus;



import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import Model.UserInfo;

public class HibernateMain {

	private TransactionTemplate transactionTemplate;  
	SessionFactory sessionFactory = null;
    Session session = null;
	
	private void updateUsers()
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory = (SessionFactory)context.getBean("sessionFactory");
		session = sessionFactory.openSession();
		transactionTemplate = (TransactionTemplate)context.getBean("transactionTemplate");
		transactionTemplate.execute(new TransactionCallback<Boolean>() {
            @Override
            public Boolean doInTransaction(TransactionStatus ts) {
            	
            	try {
            	
            		UserInfo user = new UserInfo();
            		user.setUserID(1);
            		user.setUserName("Mike");
            		user.setPwd("123");
            		user.setUserType("VVip");

            		session.save(user);
                    
            		UserInfo anotherUser = new UserInfo();
            		anotherUser.setUserID(2);
            		anotherUser.setUserName("Peter");
            		anotherUser.setPwd("456");
            		anotherUser.setUserType("Vip");

            		session.save(anotherUser);
            		session.flush();
                }
                catch (Exception e) {
                	System.out.println("Roll Back");
                	ts.setRollbackOnly();
                	e.printStackTrace();
                	return false;
                }
            	System.out.println("Correct");
                return true;
            }
			
        });
		
		session.close();
		sessionFactory.close();
	}
	
	public static void main(String[] args) {
		
		
        try{
        	HibernateMain main = new HibernateMain();
        	main.updateUsers();        		
        }
        catch(Exception e)
        {
        	e.printStackTrace();        	
        }   
	}
}
