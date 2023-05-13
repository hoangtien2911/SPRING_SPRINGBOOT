package com.in28minutes.jpa.hibernate.JpaHibernateInDepth.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "EmployeeType") //InheritanceType.SINGLE_TABLE
public abstract class Employee {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue
	protected Long id;

	@Column(nullable = false)
	protected String name;

	protected Employee() {

	}

	public Employee(String name) {
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

	@Override
	public String toString() {
		return String.format("Employee[%s]", name);
	}

}
