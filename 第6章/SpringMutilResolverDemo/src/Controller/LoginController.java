package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class LoginController extends AbstractController{
    
	public ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response)throws Exception{
	        
	        String userName=request.getParameter("username");

	        //省略身份验证的动作
	        
	        ModelAndView mav=new ModelAndView("welcome");
	        mav.addObject("userName",userName);
	        return mav;
	    }
    
}




    
    