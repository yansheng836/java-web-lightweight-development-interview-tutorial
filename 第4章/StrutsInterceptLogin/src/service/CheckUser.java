package service;

public class CheckUser {
   //判断用户是否存在
	     public static boolean isUser(String username, String password)
	     {
	         String name = username.trim();
	         String pwd = password.trim();
	        
	         if(name.equals("Java") && pwd.equals("StrutsIntercept"))
	         {
	             return true;
	         }
	         return false;
	     }
	}    
