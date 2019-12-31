package com;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class SayHello {
	
	
	private HelloWorldSpring helloWorldSpring;

	public HelloWorldSpring getHelloWorldSpring() {
		return helloWorldSpring;
	}
	
	public void setHelloWorldSpring(HelloWorldSpring helloWorldSpring) {
		this.helloWorldSpring = helloWorldSpring;
	}

	public void sayHello(){
		System.out.println("Say Hello:" + helloWorldSpring.sayHello());		
	}
}
