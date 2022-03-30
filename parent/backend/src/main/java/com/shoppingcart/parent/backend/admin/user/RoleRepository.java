package com.shoppingcart.parent.backend.admin.user;

import org.springframework.data.repository.CrudRepository;

import com.shoppingcart.common.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

}
