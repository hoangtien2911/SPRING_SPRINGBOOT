package com.hoangtien.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;


//Delete class 035 step 29 
@Service
public class AuthenticationService {
	public boolean authenticate(String username, String password) {
		boolean isValidUsername = username.equalsIgnoreCase("in28minutes");
		boolean isValidPassword = password.equalsIgnoreCase("dummy");		
		return isValidPassword && isValidUsername;
	}
}
