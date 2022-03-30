package com.shoppingcart.parent.backend.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.shoppingcart.common.entity.Role;
import com.shoppingcart.common.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		Role roleAdmin = entityManager.find(Role.class,1);
		User srikanth = new User("srikanth_test@gmail.com","srikanth","sm","srikanth");
		srikanth.addRole(roleAdmin);
		User savedUser = userRepo.save(srikanth);
		assertThat(savedUser.getId()).isPositive();
	}
	
	@Test
	public void testCreateUserWithTwoRoles() {
		User srinath = new User("srinath@gmail.com","srinath","sm","srinath");
		Role roleEditor = entityManager.find(Role.class,3);
		Role roleShipper = entityManager.find(Role.class,4);
		srinath.addRole(roleShipper);
		srinath.addRole(roleEditor);
		User savedUser = userRepo.save(srinath);
		assertThat(savedUser.getId()).isPositive();
	}
	
	
}
