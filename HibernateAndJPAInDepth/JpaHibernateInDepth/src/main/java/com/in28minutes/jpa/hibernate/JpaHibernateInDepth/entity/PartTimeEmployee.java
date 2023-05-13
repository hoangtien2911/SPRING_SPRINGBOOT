package com.in28minutes.jpa.hibernate.JpaHibernateInDepth.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {
	private BigDecimal hourlyWage;
	
	protected PartTimeEmployee() {
	}

	public PartTimeEmployee(String name, BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}
	
	
}
