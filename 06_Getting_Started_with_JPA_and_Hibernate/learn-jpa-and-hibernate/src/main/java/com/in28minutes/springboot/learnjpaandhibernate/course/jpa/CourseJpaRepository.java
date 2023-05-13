package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {
	
	// @Autowired
	//Better recommendation for annotation is @PersistenceContext
	@PersistenceContext
	private EntityManager entityManager;
	public void insert(Course course) {
		//update insert
		entityManager.merge(course);
	}
	
	public void deleteById(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	
	public List<Course> findAll() {
		TypedQuery<Course> namedQuery = entityManager.createNamedQuery("find_all_Course", Course.class);
		return namedQuery.getResultList();
	}
}
