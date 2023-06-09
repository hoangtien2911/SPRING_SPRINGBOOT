package com.in28minutes.learnspringframework.examplea.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBussinessClass {
	@Autowired
	Dependency1 dependency1;
//	@Autowired
	Dependency2 dependency2;

	/*
	 * Even if you don't add @Autowired in, if you just create a constructor with
	 * all the dependencies present in here, Spring would automatically use the
	 * constructor to create the object even if you don't have @Autowired in there
	 */

	/*
	 * Spring team recommends Constructor-based injection ALWAYS is because all the
	 * initialization happens in just one method and once the initialization is
	 * done, the bean is ready for use.
	 */

//	@Autowired
//	public YourBussinessClass(Dependency1 dependency1, Dependency2 dependency2) {
//		super();
//		System.out.println("Constructer Injection - YourBussinessClass");
//		this.dependency1 = dependency1;
//		this.dependency2 = dependency2;
//	}

//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("Setter Injection - setDependency1");
//		this.dependency1 = dependency1;
//	}
//
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("Setter Injection - setDependency2");
//		this.dependency2 = dependency2;
//	}
//	
//	public Dependency1 getDependency1() {
//		return dependency1;
//	}

	public String toString() {
		return "Using " + dependency1 + " and " + dependency2;
	}
	public void hehe( ) {
		System.out.println("he " + dependency1);
	}
}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}

@Configuration
@ComponentScan // current package
public class DepInjectionLauncherApplication {

	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)) {
//			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(YourBussinessClass.class));
			context.getBean(YourBussinessClass.class).hehe();
		}
	}
}
