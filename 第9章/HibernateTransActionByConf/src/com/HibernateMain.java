package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class HibernateMain {

	private JdbcTemplate jdbcTemplate;  
    public JdbcTemplate getJdbcTemplate() {  
        return jdbcTemplate;  
    }  
  
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
        this.jdbcTemplate = jdbcTemplate;  
    }  
	private void updateUsers()
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate"); 
		String sql="INSERT INTO userInfo VALUES(?,?,?,?)";
		jdbcTemplate.update(sql, "1","Mike","123","VIP");  
		jdbcTemplate.update(sql, "2","Peter","456","VIP");
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
