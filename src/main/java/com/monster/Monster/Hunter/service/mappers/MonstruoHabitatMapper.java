package com.monster.Monster.Hunter.service.mappers;

import com.monster.Monster.Hunter.persistence.entities.MonstruoHabitat;
import com.monster.Monster.Hunter.service.dto.MonstruoHabitatDTO;

public class MonstruoHabitatMapper {
	
	public static MonstruoHabitatDTO toDto (MonstruoHabitat mh) {
		MonstruoHabitatDTO dto= new MonstruoHabitatDTO();
		dto.setId(mh.getHabitat().getId());
		dto.setDescripcion(mh.getHabitat().getDescripcion());
		dto.setNombre(mh.getHabitat().getNombre());
		dto.setImagen(mh.getHabitat().getImagen());
		
		
		return dto;
		
	}

}