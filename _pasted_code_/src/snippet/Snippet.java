package snippet;

public class Snippet {
	server:
	  port: 9000
	
	spring:
	  datasource:
	    url: jdbc:mysql://localhost:3306/user_registration
	    username: root
	    password: root
	    driver-class-name: com.mysql.cj.jdbc.Driver
	  jpa:
	    show-sql: true
}
