package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.model.UserInfo;



public class UserInfoDao {

    private SessionFactory sessionFactory = null;  

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
        return sessionFactory.openSession();
    }
    
	public UserInfo getUserInfoByLoginName(String loginName,String pwd) {
				
		
		Criteria crit = getSession().createCriteria(UserInfo.class);
        crit.add(Restrictions.eq("username", loginName));
        crit.add(Restrictions.and( Restrictions.eq("password", pwd) ));
         
		List<UserInfo> list = crit.list();


		if (null == list || list.size() == 0)
			return null;
		else
			return list.get(0);
	}

//	
}
