package com.monster.Monster.Hunter.persistence.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.monster.Monster.Hunter.persistence.entities.Monstruo;

public interface MonstruoRepository extends ListCrudRepository<Monstruo, Integer>{

	List<Monstruo> findByNombreContaining (String nombre);
}
