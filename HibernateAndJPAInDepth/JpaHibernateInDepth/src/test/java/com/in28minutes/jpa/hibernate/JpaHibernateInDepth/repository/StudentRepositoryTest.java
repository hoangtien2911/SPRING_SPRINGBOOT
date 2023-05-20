package com.in28minutes.jpa.hibernate.JpaHibernateInDepth.repository;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.JpaHibernateInDepthApplication;
import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.entity.Passport;
import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootTest(classes = JpaHibernateInDepthApplication.class)
class StudentRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;

	@Autowired
	EntityManager em; // playing with persistent context (= hibernate session)

	// Session & Session Factory
	// Entity Manager & Persistence Context
	// Transaction

	@Test
	@Transactional
	public void someOperationToUnderstandPersistenceContext0() { //start transaction
		// Database Operation 1 - Retrieve student
		Student student = em.find(Student.class, 20001L);
		// Persistence Context (student)

		// Database Operation 2 - Retrieve passport
		Passport passport = student.getPassport();
		// Persistence Context (student, passport)

		// Database Operation 3 - update passport
		passport.setNumber("E123457");
		// Persistence Context (student, passport++)

		// Database Operation 4 - update student
		student.setName("Ranga - updated");
		// Persistence Context (student++ , passport++)
	} //end transaction
	
	@Test
//	@Transactional
	public void someOperationToUnderstandPersistenceContext() { //start transaction
		repository.someOperationToUnderstandPersistenceContext();
	} //end transaction

	@Test
	@Transactional
	// @Transactional, this session is delayed session only killed at and of the
	// test(Hibernate session)
	// Lazy fetching is you get the details only when they are needed
	
	//Everything should succeed or nothing should succeed
	//if this operation fails, all changes done to the database 
	//before this should be rolled back (concept call add transaction)
	public void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student -> {}", student);
		logger.info("passport -> {}", student.getPassport());
	}
	
	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudent() {
		Passport passport = em.find(Passport.class, 40001L);
		logger.info("passport -> {}", passport);
		logger.info("student -> {}", passport.getStudent());
	}
	
	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student = em.find(Student.class, 20001L);
		
		logger.info("student -> {}", student);
		logger.info("courses -> {}", student.getCourses());
	}

}
