package com;


import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Model.Course;
import Model.Student;


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
        
        Student s1 = new Student();
        s1.setStudentID("1");
        s1.setStudentName("Peter");
        Student s2 = new Student();
        s2.setStudentID("2");
        s2.setStudentName("Mike");
        Student s3 = new Student();
        s3.setStudentID("3");
        s3.setStudentName("John");
        
        Course c1 = new Course();
        c1.setCourseID("c1");
        c1.setCourseName("Math");
        Course c2 = new Course();
        c2.setCourseID("c2");
        c2.setCourseName("Java");

        Course c3 = new Course();
        c3.setCourseID("c3");
        c3.setCourseName("C#");
        
        Set<Course> computerCourses = new HashSet<Course>();
        computerCourses.add(c2);
        computerCourses.add(c3);
        Set<Course> mathCourses = new HashSet<Course>();
        mathCourses.add(c1);
                
        s1.setCourses(computerCourses);
        s2.setCourses(computerCourses);
        s3.setCourses(mathCourses);
        
        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.flush();
        
        session.delete(s3);
        session.flush();
        
        
        session.delete(c1);
        session.flush();
        
        session.close();
		sessionFactory.close(); 
   
	}
}
