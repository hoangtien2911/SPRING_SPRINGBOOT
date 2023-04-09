package com.in28minutes.learnspringframework.examplea.c1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;

@Configuration
@ComponentScan
public class RealWorldSpringContextLauncherApplication {
		
	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext
								(RealWorldSpringContextLauncherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
			
		}
	}
}
