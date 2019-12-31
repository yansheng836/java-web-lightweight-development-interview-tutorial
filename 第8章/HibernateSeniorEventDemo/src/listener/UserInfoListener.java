package listener;


import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.event.spi.SaveOrUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;

import Model.UserInfo;



public class UserInfoListener implements SaveOrUpdateEventListener, PostUpdateEventListener ,PostDeleteEventListener  {

	@Override
	public void onSaveOrUpdate(SaveOrUpdateEvent event)
	 {
	     System.out.println("Save Or Update");
	     Object obj = event.getObject();  
	     System.out.println(event.getObject());  
	     if(obj instanceof UserInfo)  
	     {  
	      ((UserInfo) obj).setUserType("VVIP");
	     }
	}    
	
	@Override
	public void onPostUpdate(PostUpdateEvent event) {  
		System.out.println("after Update");
		System.out.println(event.getEntity().getClass().getName());  
		
		 Object obj = event.getEntity();  
	     System.out.println(obj);  
	     if(obj instanceof UserInfo)  
	     {  
	      ((UserInfo) obj).setUserType("VVIP");
	     }
		
		for (int i = 0; i < event.getState().length; i++) {  
		// 更新前的值  
		Object oldValue = event.getOldState()[i];  
		// 更新后的新值  
		Object newValue = event.getState()[i];  
		//更新的属性名  
		String propertyName = event.getPersister().getPropertyNames()[i]; 
		System.out.println("property" + propertyName + "change from " +oldValue + " to " +  newValue);
		}  
		}

	@Override
	public boolean requiresPostCommitHanding(EntityPersister arg0) {
		return false;
	}

	@Override
	public void onPostDelete(PostDeleteEvent event) {
		
		System.out.println("after delete");
		System.out.println(event.getEntity().getClass().getName());  
		for (int i = 0; i < event.getDeletedState().length; i++) {  
		// 更新前的值  
		Object deletedValue = event.getDeletedState()[i]; 
		  
		//更新的属性名  
		String propertyName = event.getPersister().getPropertyNames()[i]; 
		System.out.println("property" + propertyName + " value " + deletedValue);
		}  
		}    
}  