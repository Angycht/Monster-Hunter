package com.monster.Monster.Hunter.persistence.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.monster.Monster.Hunter.persistence.entities.Habitat;

public interface HabitatRepository extends ListCrudRepository<Habitat, Integer> {

	List<Habitat> findByNombreContaining (String nombre);
}
