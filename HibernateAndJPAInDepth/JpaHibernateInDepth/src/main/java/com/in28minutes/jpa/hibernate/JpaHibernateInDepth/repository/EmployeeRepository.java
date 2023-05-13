package com.in28minutes.jpa.hibernate.JpaHibernateInDepth.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.entity.Employee;
import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.entity.FullTimeEmployee;
import com.in28minutes.jpa.hibernate.JpaHibernateInDepth.entity.PartTimeEmployee;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
//Caused by: org.springframework.dao.InvalidDataAccessApiUsageException:
//No EntityManager with actual transaction available for current thread
//- cannot reliably process 'remove' call
public class EmployeeRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em; //it's is an interface something call a persistent context
	
	public void insert(Employee employee) {
		em.persist(employee);
	}
	
	public List<PartTimeEmployee> retrieveAllPartTimeEmployees() {
		return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}

	public List<FullTimeEmployee> retrieveAllFullTimeEmployees() {
		return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}


}
