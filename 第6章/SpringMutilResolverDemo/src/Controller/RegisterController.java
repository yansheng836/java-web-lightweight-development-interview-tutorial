package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class RegisterController extends AbstractController{
    
	public ModelAndView handleRequestInternal(HttpServletRequest request,
            HttpServletResponse response)throws Exception{
	        
	        String userName=request.getParameter("username");

	        //省略注册的动作
	        
	        ModelAndView model=new ModelAndView("welcome");
	        model.addObject("userName",userName);
	        return model;
	    }
    
}




    
    
