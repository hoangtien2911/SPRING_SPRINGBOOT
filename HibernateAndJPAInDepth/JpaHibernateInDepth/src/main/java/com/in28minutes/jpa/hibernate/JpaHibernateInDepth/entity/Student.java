package com.in28minutes.jpa.hibernate.JpaHibernateInDepth.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue
	private Long id;

//	@Column(name = "fullname", nullable = false) //false: can not null
	@Column(nullable = false)
	private String name;

	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport;

	@ManyToMany // owning side of relationship
	@JoinTable(name = "STUDENT_COURSE", joinColumns = @JoinColumn(name = "STUDENT_ID"), inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
	// joinColumn - STUDENT_ID
	// inverseJoinColumn - COURSE_ID
	private List<Course> courses = new ArrayList<>();

	protected Student() {

	}

	public Student(String name) {
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

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}

	public void removeCourse(Course course) {
		this.courses.remove(course);
	}

	@Override
	public String toString() {
		return String.format("Student[%s]", name);
	}

}
