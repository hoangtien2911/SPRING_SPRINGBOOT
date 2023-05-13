package com.in28minutes.jpa.hibernate.JpaHibernateInDepth.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.JpaHibernateInDepthApplication;
import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.entity.Course;
import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@SpringBootTest(classes = JpaHibernateInDepthApplication.class)
class JPQLTest {
	// Java persistent query language
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	public void jpql_basic() {
		Query createQuery = em.createQuery("select c From Course c");
		List resultList = createQuery.getResultList();
		logger.info("select c From Course c -> {}", resultList);
	}

	@Test
	public void jpql_typed() {
		TypedQuery<Course> createQuery = em.createNamedQuery("query_get_all_courses", Course.class);
		List<Course> resultList = createQuery.getResultList();
		logger.info("select c From Course c -> {}", resultList);
	}

	@Test
	public void jpql_where() {
		TypedQuery<Course> createQuery = em.createNamedQuery("query_get_100_Step_courses", Course.class);
		List<Course> resultList = createQuery.getResultList();
		logger.info("select c From Course c where name like '%100 steps' -> {}", resultList);
	}

	@Test
	public void jpql_courses_without_students() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c where c.students is empty", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Results -> {}", resultList);
		// [Course[Spring in 50 Steps]]
	}

	@Test
	public void jpql_courses_with_atleast_2_students() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c where size(c.students) >= 2", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Results -> {}", resultList);
		// [Course[JPA in 50 Steps]]

//		select
//        c1_0.id,
//        c1_0.created_date,
//        c1_0.last_updated_date,
//        c1_0.name 
//    from
//        course c1_0 
//    where
//        (
//            select
//                count(1) 
//            from
//                student_course s1_0 
//            where
//                c1_0.id=s1_0.course_id
//        )>=2
	}

	@Test
	public void jpql_courses_ordered_by_students() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c order by size(c.students) desc",
				Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("Results -> {}", resultList);
	}

	@Test
	public void jpql_students_with_passports_in_a_certain_pattern() {
		TypedQuery<Student> query = em.createQuery("Select s from Student s where s.passport.number like '%1234%'",
				Student.class);
		List<Student> resultList = query.getResultList();
		logger.info("Results -> {}", resultList);
	}
	// like
	// between 1 and 2
	// IS NULL
	// upper, lower, trim, length

	// JOIN => Select c, s from Course c JOIN c.students s
	// LEFT JOIN => Select c, s from Course c LEFT JOIN c.students s
	// CROSS JOIN => Select c, s from Course c, Student s
	// 3 and 4 =>3 * 4 = 12 Rows
	@Test
	public void join() {
		Query query = em.createQuery("Select c, s from Course c JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Results Size -> {}", resultList.size());
		for (Object[] result : resultList) {
			logger.info("1. Course: {} Student: {}", result[0], result[1]);
		}
	}

	@Test
	public void left_join() {
		Query query = em.createQuery("Select c, s from Course c LEFT JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Results Size -> {}", resultList.size());
		for (Object[] result : resultList) {
			logger.info("2. Course: {} Student: {}", result[0], result[1]);
		}
	}

	@Test
	public void cross_join() {
		Query query = em.createQuery("Select c, s from Course c, Student s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Results Size -> {}", resultList.size());
		for (Object[] result : resultList) {
			logger.info("3. Course: {} Student: {}", result[0], result[1]);
		}
	}
}
