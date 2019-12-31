package com.interceptor;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import org.springframework.web.servlet.HandlerInterceptor;  
import org.springframework.web.servlet.ModelAndView;  

public class SpringMVCInterceptor implements HandlerInterceptor {
	 
	@Override
	public boolean preHandle(HttpServletRequest request,  
	            HttpServletResponse response, Object handler) throws Exception {
		 String requestUri = request.getRequestURI();  
	     String contextPath = request.getContextPath();  
	     String url = requestUri.substring(contextPath.length());  
	     System.out.println("url is: " + url);
	     return true;  
	    }
	 
	 
	 @Override  
	 public void postHandle(HttpServletRequest request,  
	            HttpServletResponse response, Object handler,  
	            ModelAndView modelAndView) throws Exception { 
	       
	          
	    }  
	  
	    @Override  
	    public void afterCompletion(HttpServletRequest request,  
	            HttpServletResponse response, Object handler, Exception ex)  
	    throws Exception {
	          
	    }  
}
