package com.monster.Monster.Hunter.persistence.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.monster.Monster.Hunter.persistence.entities.Material;

public interface MaterialRepository extends ListCrudRepository<Material, Integer>{
	
	List<Material> findByNombreContaining (String nombre);

}
