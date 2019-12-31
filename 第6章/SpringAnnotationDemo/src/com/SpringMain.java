package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"conf/applicationContext-*.xml");

		
		SayHello sayHello = (SayHello) context.getBean("SayHello");
		sayHello.sayHello();		
	}
}
