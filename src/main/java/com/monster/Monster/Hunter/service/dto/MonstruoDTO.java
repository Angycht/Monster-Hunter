package com.monster.Monster.Hunter.service.dto;

import java.util.List;

import com.monster.Monster.Hunter.persistence.entities.Familia;
import com.monster.Monster.Hunter.persistence.entities.Habitat;
import com.monster.Monster.Hunter.persistence.entities.Material;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MonstruoDTO {
	
	private int id;
	private String nombre;
	private String descripcion;
	private String familia;
	private String partesRompibles;
	
	private List<Habitat> habitat;
	private List<Material> materiales;
	

	
}
