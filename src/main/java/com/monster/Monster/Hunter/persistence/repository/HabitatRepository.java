package com.monster.Monster.Hunter.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.monster.Monster.Hunter.persistence.entities.Habitat;

public interface HabitatRepository extends ListCrudRepository<Habitat, Integer> {

	List<Habitat> findByNombreContaining (String nombre);
	@Query("SELECT h FROM Habitat h LEFT JOIN FETCH h.monstruoHabitats WHERE h.id = :id")
    Optional<List<Habitat>> findByIdWithMonstruos(@Param("id") int id);
}
