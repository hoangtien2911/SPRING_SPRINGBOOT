package com.in28minutes.learnspringframework.examplea.d1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {	
}

@Component
@Lazy //Class bean is now not initialized at start up
class ClassB {
	private ClassA classA;
	public ClassB(ClassA classA) {
		//Logic
		System.out.println("Some Initialization logic");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("Do something in here!");
	}
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
		
	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext
								(LazyInitializationLauncherApplication.class)) {
			System.out.println("Initialization of context is completed");
			// With lazy: Bean initialized when it is first made use
			// of in the application
			context.getBean(ClassB.class).doSomething();
		}
	}
}
