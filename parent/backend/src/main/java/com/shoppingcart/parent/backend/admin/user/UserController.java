package com.shoppingcart.parent.backend.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.common.entity.User;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping("/users/save")
	public boolean saveNewUser(@RequestBody User user) {
		User savedUser = userService.saveNewUser(user);
		if(savedUser!=null) {
			return true;
		}
		
		return false;
	}
	

}
