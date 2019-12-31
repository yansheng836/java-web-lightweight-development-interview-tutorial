package com;

import java.util.HashSet;
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
            //不指定文件名默认是找hibernate.cfg.xml文件
            //registry = new StandardServiceRegistryBuilder().configure().build(); 
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
        Card anotherCard = new Card();
        anotherCard.setCardID("Card456");
        anotherCard.setBank("Citi");
        anotherCard.setBalance(100f);
        
        
        Person person = new Person();
        person.setID("Person123");
        person.setName("Peter");
        person.setPhone("123456");
        
        Set<Card> cards = new HashSet<Card>();
        card.setPerson(person);
        anotherCard.setPerson(person);
        cards.add(card);
        cards.add(anotherCard);
        
        person.setCards(cards);
                
        session.save(person);
        session.flush();
        
        
    	Person onePerson = (Person)session.load(Person.class, "Person123");
        Set<Card> cardSet = onePerson.getCards() ;
    	
        //省略System.out.println打印语句

        Card oneCard = (Card)session.load(Card.class, "Card123");
        Person cardOwner = oneCard.getPerson();
        //省略System.out.println打印语句
        
//    	session.delete(onePerson);
//    	session.flush();
    	
    	
        session.close();
		sessionFactory.close(); 
   
	}
}
