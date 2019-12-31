package com;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Model.Card;
import Model.Person;


public class HibernateMain {
	public static void main(String[] args) {
		
		StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        try{
            registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }catch(Exception ex){
            ex.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
        
        Session session = sessionFactory.openSession();
        
        Card card1 = new Card();
        card1.setCardID("Card123");
        card1.setPersonID("Person123");
        card1.setBank("Citi");
        card1.setBalance(100f);
        
        Person person = new Person();
        person.setID("Person123");
        person.setName("Peter");
        person.setPhone("123456");
        
        
        Set<Card> cards = new HashSet<Card>();
        cards.add(card1);
        person.setCards(cards);
        
        session.save(person);
        session.flush();
	
    	
        session.close();
		sessionFactory.close(); 
   
	}
}
