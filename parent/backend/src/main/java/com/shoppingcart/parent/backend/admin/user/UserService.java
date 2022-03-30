package com.shoppingcart.parent.backend.admin.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shoppingcart.common.entity.Role;
import com.shoppingcart.common.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<User> getAllUsers() {
		return (List<User>) userRepo.findAll();
	}

	public User saveNewUser(User user) {
		User userExists = userRepo.findByEmail(user.getEmail());
		if (userExists != null) {
			user.setId(userExists.getId());
		}
		Set<Role> roles = user.getRoles();
		user.setRoles(new HashSet<Role>());
		encodePassword(user);
		roles.forEach(role -> {
			user.addRole(entityManager.find(Role.class, Integer.parseInt(role.getName())));
		});
		userRepo.save(user);
		return user;
	}
	
	private void encodePassword(User user) {
		String password = passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
	}

}
