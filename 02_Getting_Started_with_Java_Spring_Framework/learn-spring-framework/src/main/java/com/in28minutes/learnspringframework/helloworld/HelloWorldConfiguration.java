package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//Release in JDK 16.
//when we create a Java class, we would create 
//a number of getter setter methods constructors, toString, equals, hashCode...
//to eliminate the verbosity(dai dong, ruom ra) in creating Java beans
//CALL this is RECORD (Record do it all for us)

record Person (String name, int age, Address address) {};
//Address - firstLine & city
record Address (String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {
	
	//The things which are managed by spring(Spring container) are what are called spring beans.
	@Bean
	public String name() {
		return "Ranga";
	}
	
	@Bean
	public int age() {
		return 15;
	}
	@Bean
	public Person person() {
		return new Person("Ravi", 20, new Address("Nguyen Van Cu", "Buon Ma Thuot"));		
	}
	
	@Bean
	public Person person2MethodCall() {
		return new Person(name(), age(), address());//name, age		
	}
	
	//alternative approach
	@Bean
	public Person person3Parameters(String name, int age, Address address3
			) {//name, age,address3		
		return new Person(name, age, address3);//name, age		
	}
	
//	No qualifying bean of type 'com.in28minutes.learnspringframework.Address'
//	available: expected single matching bean but found 2: address2,address3
	@Bean
	@Primary
	public Person person4Parameters(String name, int age, Address address
			) {//name, age,address2		
		return new Person(name, age, address);//name, age		
	}
	
	@Bean	
	public Person person5Qualifier(String name, int age
			, @Qualifier("address3qualifier") Address address
			) {//name, age,address2		
		return new Person(name, age, address);//name, age		
	}
	
	//default name of the bean is the name of the method
	@Bean(name = "address2")
	@Primary
	public Address address() {
		return new Address("Nguyen Luong Bang", "Buon Ma Thuot");
	}
	
	@Bean(name = "address3")
	@Qualifier("address3qualifier")
	public Address address3() {
		return new Address("Cong Hoa", "Ho Chi Minh");
	}
}
