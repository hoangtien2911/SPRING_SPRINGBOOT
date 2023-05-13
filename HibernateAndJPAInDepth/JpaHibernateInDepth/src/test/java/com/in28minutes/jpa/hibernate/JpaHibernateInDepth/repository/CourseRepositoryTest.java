package com.in28minutes.jpa.hibernate.JpaHibernateInDepth.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.JpaHibernateInDepthApplication;
import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.entity.Course;
import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.entity.Review;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootTest(classes = JpaHibernateInDepthApplication.class)
class CourseRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;
	
	@Autowired
	EntityManager em;


	@Test
	public void findById_basic() {
		Course course = repository.findById(10001L);
		
		assertEquals("JPA in 50 Steps", course.getName());
		logger.info("Testing is running");
		
	}
	
	@Test
	@Transactional
	//if don't have transaction in here will have two boundary of transaction
	public void findById_firstLevelCatchDemo() {
		Course course = repository.findById(10001L);
		Course course1 = repository.findById(10001L);
		assertEquals("JPA in 50 Steps", course.getName());
		assertEquals("JPA in 50 Steps", course1.getName());
		logger.info("Testing is running");
	}

//	@Test
//	@DirtiesContext
//	public void deleteById_basic() {
//		repository.deleteById(10001L);
//		assertNull(repository.findById(10001L));
//	}

	@Test
	@DirtiesContext // data in database will not change(leave the data as it was before
	// you executed the unit test) IMPORTANT
	// Will ROLL BACK
	public void save() {
		// get a courser
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 Steps", course.getName());
		// update details
		course.setName("JPA in 50 Steps - Update");
		repository.save(course);
		// check the value
		Course course1 = repository.findById(10001L);
		assertEquals("JPA in 50 Steps - Update", course1.getName());
	}

	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		repository.playWithEntityManager();
	}

	@Test
	@Transactional
	public void retrieveReviewsForCourse() {
		Course course = repository.findById(10001L);
		logger.info("{}", course.getReviews());
	}
	
	@Test
//	@Transactional
	public void retrieveCourseForReview() {
		Review review = em.find(Review.class, 50001L);
		logger.info("Tien {}", review.getCourse());
	}

}
