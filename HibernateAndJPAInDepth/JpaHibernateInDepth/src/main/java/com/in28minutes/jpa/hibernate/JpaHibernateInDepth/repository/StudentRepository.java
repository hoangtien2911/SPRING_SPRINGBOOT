package com.in28minutes.jpa.hibernate.JpaHibernateInDepth.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.entity.Course;
import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.entity.Passport;
import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
//Caused by: org.springframework.dao.InvalidDataAccessApiUsageException:
//No EntityManager with actual transaction available for current thread
//- cannot reliably process 'remove' call

public class StudentRepository {
	@Autowired
	EntityManager em; //it's is an interface something call a persistent context
	public Student findById(Long id) {
		return em.find(Student.class, id);
	}
	
	public void deleteById(Long id) {
		Student student = findById(id);
		em.remove(student);
	}
	
	public Student save(Student student) {
		if (student.getId() == null) {
			//Insert
			em.persist(student);
		} else {
			//Update
			em.merge(student);
		}
		return student;
	}
	
	public void saveStudentWithPassport() {
		Passport passport = new Passport("Z123456");
		em.persist(passport);

		Student student = new Student("Mike");

		student.setPassport(passport);
		em.persist(student);	
	}//continues to be managed by the entity manager until the end of the transaction


	//Folder 6 007 step 27
	public void someOperationToUnderstandPersistenceContext() { //start transaction
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
	
	public void insertHardcodedStudentAndCourse(){
		Student student = new Student("Jack");
		Course course = new Course("Microservices in 100 Steps");
		em.persist(student);
		em.persist(course);
		
		student.addCourse(course);
		course.addStudent(student);
		em.persist(student); //persist the owning side
	}

	public void insertStudentAndCourse(Student student, Course course){
		//Student student = new Student("Jack");
		//Course course = new Course("Microservices in 100 Steps");
		student.addCourse(course);
		course.addStudent(student);

		em.persist(student);
		em.persist(course);
	}
}
