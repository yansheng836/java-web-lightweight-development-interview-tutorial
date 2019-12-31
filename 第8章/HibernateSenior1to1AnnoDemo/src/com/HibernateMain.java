package com;


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
        
        Card card = new Card();
        card.setCardID("Card123");
        card.setBank("Citi");
        card.setBalance(100f);
        
        
        Person person = new Person();
        person.setID("Person123");
        person.setName("Peter");
        person.setPhone("123456");
        card.setPerson(person);
        person.setCard(card);
                
        session.save(person);
        session.flush();
        
        
    	Person onePerson = (Person)session.load(Person.class, "Person123");
        Card oneCard = onePerson.getCard();
    	System.out.println(oneCard.getCardID() + "\t" + oneCard.getPerson().getName() + "\t" + oneCard.getBank() + "\t" + oneCard.getBalance() );

    	session.delete(onePerson);
    	session.flush();
    	
    	session.save(card);
     	session.flush();
         
     	oneCard = (Card)session.load(Card.class, "Card123");
     	onePerson = oneCard.getPerson();
        
     	System.out.println(onePerson.getName() + "\t" + onePerson.getPhone());

     	session.delete(oneCard);
     	session.flush();

    	
        session.close();
		sessionFactory.close(); 
   
	}
}
