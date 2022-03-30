package com.shoppingcart.parent.backend.admin.user;

import org.springframework.data.repository.CrudRepository;

import com.shoppingcart.common.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	public User findByEmail(String email);
}
