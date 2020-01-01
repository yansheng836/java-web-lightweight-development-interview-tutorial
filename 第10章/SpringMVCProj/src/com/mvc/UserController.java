package com.mvc;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  



import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  



import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;  

import com.model.User;
import com.service.UserService;

  
@Controller  
public class UserController {  
    @Resource(name="userService")  
    private UserService userService;  
      
    @RequestMapping("/addUser")  
    public String addUser(User user){  
        userService.addUser(user);  
        return "redirect:/displayUsers";  
    }  
     
    @RequestMapping("/displayUsers") 
    public String getAll(HttpServletRequest request){  
        List<User> users = userService.getAll();  
        request.setAttribute("users", users);  
        return "/displayUsers";  
    }  
    
    @RequestMapping("/deleteUser/{id}")  
    public String deleteUser(@PathVariable String id,HttpServletResponse response){  
        userService.deleteUser(id);  
        return "redirect:/displayUsers";        
    }  
      
    @RequestMapping("/getUser/{id}")  
    public String getUser(@PathVariable String id,HttpServletRequest request){  
        User user = userService.getUser(id);  
        request.setAttribute("user", user);  
        return "/editUser";  
    }  
      
    @RequestMapping("/modifyUser")  
    public String modifyUser(User user){  
        userService.modifyUser(user);  
        return "redirect:/displayUsers";  
          
    }  
  
}  
