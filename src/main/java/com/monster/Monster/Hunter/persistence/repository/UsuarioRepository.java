package com.monster.Monster.Hunter.persistence.repository;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.monster.Monster.Hunter.persistence.entities.Usuario;

public interface UsuarioRepository extends ListCrudRepository<Usuario,Integer> {

	Optional<Usuario> findByCorreo(String correo);
}
