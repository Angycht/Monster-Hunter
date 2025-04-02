package com.monster.Monster.Hunter.persistence.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.monster.Monster.Hunter.persistence.entities.Rol;

public interface RolRepository extends ListCrudRepository<Rol, Integer>{
	
	List<Rol> findByIdUsuario(int idUsuario);

}
