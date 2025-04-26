package com.monster.Monster.Hunter.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monster.Monster.Hunter.persistence.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>  {

	Optional<Role> findByNombre(String string);
	
}
