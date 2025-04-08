package com.monster.Monster.Hunter.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monster.Monster.Hunter.persistence.entities.Role;
import com.monster.Monster.Hunter.persistence.enums.RoleList;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByNombre(RoleList name);
}