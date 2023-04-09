package com.in28minutes.learnspringframework.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PacmanGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		//1: Launch a Spring Context or Spring Application with add configuration
		//Inside JVM, have a Spring Context which is managing all the beans
		//that you have configured
		try (var context =
				new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			//2: Configure the things that we want to Spring to manage - 
			//HelloWorldConfiguration - @Configuration
			//name - @Bean		
			//Using configuration class to create 
			//a annotation @Configuration application context
			
			//3: Retrieving Beans managed by Spring
			// is by using context dot get bean and giving the name of the bean
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			System.out.println(context.getBean("person"));
			System.out.println(context.getBean("person2MethodCall"));
			System.out.println(context.getBean("person3Parameters"));		
			
			//making use of context or get been passing the name as an attribute
			//(use the name of the bean)		
			System.out.println(context.getBean("address2"));	
			//alternatives
			//use the type of the bean to be able to retrieve it back
			System.out.println(context.getBean(Address.class));
			//what if multiple matching beans are available
			System.out.println(context.getBean(Person.class));
			
			System.out.println(context.getBean("person5Qualifier"));
			
			//List all beans managed by Spring Framework
//			System.out.println("List all beans managed by Spring Framework");
//			Arrays.stream(context.getBeanDefinitionNames())
//				.forEach(System.out::println);;//method reference
		}										
	}

}
