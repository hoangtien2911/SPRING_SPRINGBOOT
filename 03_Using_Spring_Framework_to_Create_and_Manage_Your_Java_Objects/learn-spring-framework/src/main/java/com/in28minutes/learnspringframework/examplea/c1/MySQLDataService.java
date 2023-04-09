package com.in28minutes.learnspringframework.examplea.c1;

import org.springframework.stereotype.Repository;

@Repository
public class MySQLDataService implements DataService {
	public int[] retrieveData() {
		return new int[] { 1, 2, 3, 4, 5 }; 
	}
}
