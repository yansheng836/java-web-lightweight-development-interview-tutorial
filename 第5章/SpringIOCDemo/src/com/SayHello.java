package com;

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
