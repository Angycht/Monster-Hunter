package com.monster.Monster.Hunter.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.monster.Monster.Hunter.persistence.entities.Familia;

public interface FamiliaRepository extends ListCrudRepository<Familia, Integer>{

	List<Familia> findByNombreContaining (String nombre);
	 @Query("SELECT f FROM Familia f LEFT JOIN FETCH f.monstruos WHERE f.id = :id")
	    Optional<Familia> findByIdWithMonstruos(@Param("id") int id);
}
