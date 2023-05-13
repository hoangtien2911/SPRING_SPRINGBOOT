package com.in28minutes.jpa.hibernate.JpaHibernateInDepth;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.entity.FullTimeEmployee;
import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.entity.PartTimeEmployee;
import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.repository.EmployeeRepository;
import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.repository.StudentRepository;

@SpringBootApplication
public class JpaHibernateInDepthApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateInDepthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Course course = courseRepository.findById(10001L);
//		logger.info("Course -> {}", course);
//		courseRepository.deleteById(10001L);
//		courseRepository.save(new Course("Micoservice"));
//		courseRepository.playWithEntityManager();

//		studentRepository.saveStudentWithPassport();

//		List<Review> reviews = new ArrayList<>();
//
//		reviews.add(new Review("5", "Great Hands-on Stuff."));
//		reviews.add(new Review("5", "Hatsoff."));
//
//		courseRepository.addReviewsForCourse(10003L, reviews);

//		studentRepository.insertHardcodedStudentAndCourse();
//		studentRepository.insertStudentAndCourse(new Student("Jack"), new Course("Microservices in 100 Steps"));
		
	
//		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
//		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));
//
//		logger.info("Full Time Employees -> {}", 
//				employeeRepository.retrieveAllFullTimeEmployees());
//		
//		logger.info("Part Time Employees -> {}", 
//				employeeRepository.retrieveAllPartTimeEmployees());
		
	}

}
