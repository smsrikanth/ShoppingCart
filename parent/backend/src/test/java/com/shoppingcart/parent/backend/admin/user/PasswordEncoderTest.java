package com.shoppingcart.parent.backend.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
	@Test 
	public void testPasswordEncoder() {
		BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
		String password= "srikanth_test";
		String encodedPassword = bcryptPasswordEncoder.encode(password);
		boolean matches = bcryptPasswordEncoder.matches(password, encodedPassword);
		assertThat(matches).isTrue();
	}

}
