package com.hoantien.SpringJwtAuthentication.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	@Autowired UserRepository repo;
	
	@Test
	public void testCreateUser( ) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawpassword = "hoangtien";
		String encodedPassword = passwordEncoder.encode(rawpassword);
		User newUser = new User("hoangtien", encodedPassword);
		User saveUser = repo.save(newUser);
		assertThat(saveUser).isNotNull();
		assertThat(saveUser.getId()).isGreaterThan(0);
	}
}
