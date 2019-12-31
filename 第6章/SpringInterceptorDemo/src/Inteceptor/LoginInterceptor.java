package Inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	//ªÒ»°urlµÿ÷∑  
        String reqUrl=request.getRequestURI();  
        if(reqUrl.contains("/loginAction")){
        	
            String username = request.getParameter("username");
        	if( username == null || 
        		username.trim().equals(""))
        	{
        		response.sendRedirect("login.jsp"); 
                return false;	
        	}
        	else
        	{
        		return true;
        	}              
        }  
        else 
        {
        	response.sendRedirect("login.jsp"); 
            return false;
        }
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	super.postHandle(request, response, handler, modelAndView);
    }
}