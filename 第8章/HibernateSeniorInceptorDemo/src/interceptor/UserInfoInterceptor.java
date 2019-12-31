package interceptor;

import java.io.Serializable;
import org.hibernate.EmptyInterceptor;

import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.hibernate.type.Type;

import Model.UserInfo;



public class UserInfoInterceptor extends EmptyInterceptor {  
    
	
	@Override  
    public void afterTransactionBegin(Transaction tx){  
    	 System.out.println("begin transaction");  
    }  
    @Override  
    public void afterTransactionCompletion(Transaction tx){  
         
    	if ( tx.getStatus() == TransactionStatus.COMMITTED) {
            System.out.println("after transaction completion");
        }
    }  
      
    
      
    @Override  
    public boolean onSave(Object entity,Serializable id, Object[] state,String[] propertyNames,Type[] types){  
    	System.out.println("on save");
    	if (entity instanceof UserInfo)
        {
            for (int index=0;index<propertyNames.length;index++)
            {
                /*找到名为"userName"的属性*/
                if ("userType".equals(propertyNames[index]))
                {
                    if(state[index].toString().equals("Vip"))
                    {
                    	state[index] = "VVIP";
                    	return true;	
                    }
                }
            }
        }
    	
        return false;  
    }  
      

    public void onDelete(Object entity,Serializable id, Object[] state,String[] propertyNames,  
            Type[] types){  
        System.out.println("on delete");  
        return;
    }  
      
    
}  
