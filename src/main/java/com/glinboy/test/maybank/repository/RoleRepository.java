package com.glinboy.test.maybank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glinboy.test.maybank.model.Role;
import com.glinboy.test.maybank.model.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(RoleName roleName);
}
