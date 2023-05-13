package com.in28minutes.jpa.hibernate.JpaHibernateInDepth.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.entity.Course;
import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.entity.Review;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
//Caused by: org.springframework.dao.InvalidDataAccessApiUsageException:
//No EntityManager with actual transaction available for current thread
//- cannot reliably process 'remove' call
public class CourseRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em; //it's is an interface something call a persistent context
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}
	
	public Course save(Course course) {
		if (course.getId() == null) {
			//Insert
			em.persist(course);
		} else {
			//Update
			em.merge(course);
		}
		return course;
	}
	
	public void playWithEntityManager() {
		Course course1 = new Course("Web Services in 100 Steps");
		em.persist(course1);
		em.flush(); // the changes up to that point are sent out to the database
		
		Course course2 = findById(10001L);
//		em.clear();// not do after this 
		course2.setName("JPA in 50 St");
//		em.detach(course2);//not update courser2
		course2.setName("JPA in 50 Steps - Updated");
		
//		em.refresh(course2); //Change is not save down to the database
		
	}//continues to be managed by the entity manager until the end of the transaction

	
	public void addHardcodedReviewsForCourse() {
		//get the course 10003
		Course course = findById(10003L);
		logger.info("course.getReviews() -> {}", course.getReviews());
		
		//add 2 reviews to it
		Review review1 = new Review("FIVE", "Great Hands-on Stuff.");	
		Review review2 = new Review("FIVE", "Hatsoff.");
		
		//setting the relationship
		course.addReview(review1);
		review1.setCourse(course);
		
		course.addReview(review2);
		review2.setCourse(course);
		
		//save it to the database
		em.persist(review1);
		em.persist(review2);
	}
	
	
	public void addReviewsForCourse(Long courseId, List<Review> reviews) {
		Course course = findById(courseId);
		logger.info("course.getReviews() -> {}", course.getReviews());
		for (Review review : reviews) {
			//setting relationship
			course.addReview(review);
			review.setCourse(course);
			em.persist(review);
		}
	}


}
