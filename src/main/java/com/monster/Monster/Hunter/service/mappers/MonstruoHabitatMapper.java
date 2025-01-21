package com.monster.Monster.Hunter.service.mappers;

import com.monster.Monster.Hunter.persistence.entities.Habitat;
import com.monster.Monster.Hunter.service.dto.MonstruoHabitatDTO;

public class MonstruoHabitatMapper {
	
	public static MonstruoHabitatDTO toDto (Habitat habitat) {
		MonstruoHabitatDTO dto= new MonstruoHabitatDTO();
		dto.setDescripcion(habitat.getDescripcion());
		dto.setNombre(habitat.getNombre());
		dto.setImagen(habitat.getImagen());
		
		return dto;
		
	}

}
