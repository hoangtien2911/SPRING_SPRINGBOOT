package com.in28minutes.jpa.hibernate.JpaHibernateInDepth.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.JpaHibernateInDepthApplication;
import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.entity.Course;

@SpringBootTest(classes = JpaHibernateInDepthApplication.class)
class CourseSpringDataRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseSpringDataRepository repository;

	@Test
	public void findById_CoursePresent() {
		Optional<Course> courseOptional = repository.findById(10001L);
		logger.info("1. {}", courseOptional.isPresent());
		assertTrue(courseOptional.isPresent());
	}

	@Test
	public void findById_CourseNotPresent() {
		Optional<Course> courseOptional = repository.findById(20001L);
		logger.info("2. {}", courseOptional.isPresent());
		assertFalse(courseOptional.isPresent());
	}

	@Test
	public void playingAroundWithSpringDataRepository() {
		// Course course = new Course("Microservices in 100 Steps");
		// repository.save(course);

		// course.setName("Microservices in 100 Steps - Updated");
		// repository.save(course);
		logger.info("Courses -> {} ", repository.findAll());
		logger.info("Count -> {} ", repository.count());
	}

	@Test
	public void sort() {
		Sort sort = Sort.by(Sort.Direction.DESC, "name").and(Sort.by(Sort.Direction.DESC, "id"));
		logger.info("Sorted Courses -> {} ", repository.findAll(sort));
		// Courses -> [Course[JPA in 50 Steps], Course[Spring in 50 Steps],
		// Course[Spring Boot in 100 Steps]]
	}

	@Test
	public void pagination() {
		PageRequest pageRequest = PageRequest.of(0, 2);
		Page<Course> firstPage = repository.findAll(pageRequest);
		logger.info("First Page -> {} ", firstPage.getContent());

		Pageable secondPageable = firstPage.nextPageable();
		Page<Course> secondPage = repository.findAll(secondPageable);
		logger.info("Second Page -> {} ", secondPage.getContent());
	}
	
	@Test
	public void findUsingName() {
		logger.info("FindByName -> {} ", repository.findByName("JPA in 50 Steps"));
	}

}
