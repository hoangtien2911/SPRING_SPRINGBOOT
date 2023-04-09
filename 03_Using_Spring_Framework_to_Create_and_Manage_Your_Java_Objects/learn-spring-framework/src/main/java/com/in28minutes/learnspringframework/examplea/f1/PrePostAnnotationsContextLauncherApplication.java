package com.in28minutes.learnspringframework.examplea.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	private SomeDependency someDependency;
	public SomeClass(SomeDependency someDependency) {
		super();
		System.out.println("All Dependencies are ready!!");
		this.someDependency = someDependency;
	}
	
	@PostConstruct //Identifies the method that will be executed after dependency injection
				   //is done to perform any initialization
	public void initialize() {
		someDependency.getReady();
	}
	
	@PreDestroy // just before the bean is removed from container or the spring IOC context, cleanup is called on it
	public void cleanUp() {
		System.out.println("Clean up");
	}
}

@Component
class SomeDependency {
	public void getReady( ) {
		System.out.println("Some logic using SomeDependency");
	}
}

@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {
		
	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext
								(PrePostAnnotationsContextLauncherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
		}
	}
}
