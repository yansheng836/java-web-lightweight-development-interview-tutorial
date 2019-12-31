package com;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        
        Card card2 = new Card();
        card2.setCardID("Card456");
        card2.setPersonID("Person123");
        card2.setBank("ICBC");
        card2.setBalance(200f);
        
        Person person = new Person();
        person.setID("Person123");
        person.setName("Peter");
        person.setPhone("123456");
        
        Map<String,Card> cards = new HashMap<String,Card>();
        cards.put(card1.getCardID(),card1);
        cards.put(card2.getCardID(),card2);
        person.setCardMap(cards);
        
        session.save(person);
        session.flush();
        
        
    	Person one = (Person)session.load(Person.class, "Person123");
    	Map<String,Card> cardsForOnePerson = one.getCardMap();
        
        for (Map.Entry<String, Card> entry : cardsForOnePerson.entrySet()) {
    	   System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue().getBalance());
    	}
    	  
//    	session.delete(person);
//    	session.flush();
    	
        session.close();
		sessionFactory.close(); 
   
	}
}
