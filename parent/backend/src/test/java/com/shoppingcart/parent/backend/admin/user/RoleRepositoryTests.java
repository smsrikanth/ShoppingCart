package com.shoppingcart.parent.backend.admin.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.shoppingcart.common.entity.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(value=false)
public class RoleRepositoryTests {

	@Autowired
	private RoleRepository roleRepo;
	
	@Test
	public void testCreateFirstRole() {
		Role roleAdmin = new Role("Admin","Admin of all");
		Role savedRole = roleRepo.save(roleAdmin);
		assertThat(savedRole.getId()).isPositive();
	}
	
	
	@Test
	public void testRestRoles() {
		Role roleSalesPerson = new Role("Sales","manages customers,prices,orders and sales report");
		Role roleEditor = new Role("Editor","manages categories,brands,products,articles and menus");
		Role roleShipper = new Role("Shipper","view products,view orders and updates order status");
		Role roleAssitant = new Role("Assistant","manage questions and reviews");
		List<Role> roles = new ArrayList<>();
		roles.add(roleSalesPerson);
		roles.add(roleEditor);
		roles.add(roleShipper);
		roles.add(roleAssitant);
		roleRepo.saveAll(roles);
		
	}
}
