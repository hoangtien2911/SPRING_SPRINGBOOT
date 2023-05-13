package com.in28minutes.jpa.hibernate.JpaHibernateInDepth.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQueries(value = { @NamedQuery(name = "query_get_all_courses", query = "Select  c  From Course c"),
//		@NamedQuery(name = "query_get_all_courses_join_fetch", query = "Select  c  From Course c JOIN FETCH c.students s"),
		@NamedQuery(name = "query_get_100_Step_courses", query = "Select  c  From Course c where name like '%100 Steps'") })
//@Table(name = "CourseDetails")
@Cacheable
public class Course {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue
	private Long id;

//	@Column(name = "fullname", nullable = false) //false: can not null
	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "course")
	private List<Review> reviews = new ArrayList<>();

	@ManyToMany(mappedBy = "courses")
	@JsonIgnore
	private List<Student> students = new ArrayList<>();

	// tell hibernate that this is the last update column
	// every time make a change to this row
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	private LocalDateTime createdDate;

	protected Course() {

	}

	public Course(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public void removeReview(Review review) {
		this.reviews.remove(review);
	}

	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}
	
	public void removeStudent(Student student) {
		this.students.remove(student);
	}

	@Override
	public String toString() {
		return String.format("Course[%s]", name);
	}

}
