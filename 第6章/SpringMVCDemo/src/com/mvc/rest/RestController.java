package com.mvc.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestController {
    
    public RestController(){
        
    }
    
    @RequestMapping(value = "/login/{userName}", method = RequestMethod.GET)   
    public ModelAndView myMethod(HttpServletRequest request, HttpServletResponse response,     
            @PathVariable("userName") String userName, ModelMap modelMap) throws Exception {  
        modelMap.put("loginUser", userName);
        return new ModelAndView("/login/hello", modelMap);
    }   
    
     @RequestMapping(value = "/welcome", method = RequestMethod.GET)  
        public String registPost() {  
         return "/welcome";
        }  
}
