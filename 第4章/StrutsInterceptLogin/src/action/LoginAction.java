package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import service.CheckUser;

public class LoginAction extends ActionSupport {
     private String username;
     private String password;
 
     public String execute() throws Exception {
         // 设置session
         Map sessionMap = ActionContext.getContext().getSession();
         sessionMap.put("username", username);
         // 验证用户
         if (    CheckUser.isUser(username, password) ) {             
             return SUCCESS;
         }
 
         return LOGIN;
     }
     
     public String getUsername() {
         return username;
     }
 
     public void setUsername(String username) {
         this.username = username;
     }
 
     public String getPassword() {
         return password;
     }
 
     public void setPassword(String password) {
         this.password = password;
     }
}