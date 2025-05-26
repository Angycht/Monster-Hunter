package com.monster.Monster.Hunter.service.mappers;

import com.monster.Monster.Hunter.persistence.entities.MonstruoHabitat;
import com.monster.Monster.Hunter.service.dto.MonstruoHabitatDTO;

public class MonstruoHabitatMapper {
	
	public static MonstruoHabitatDTO toDto (MonstruoHabitat mh) {
		MonstruoHabitatDTO dto= new MonstruoHabitatDTO();
		 if (mh.getHabitat() != null) {
	            dto.setId(mh.getHabitat().getId());
	            dto.setDescripcion(mh.getHabitat().getDescripcion());
	            dto.setNombre(mh.getHabitat().getNombre());
	            dto.setImagen(mh.getHabitat().getImagen());
	        } else {
	            // Opcional: puedes asignar valores por defecto o dejar el DTO vacío
	            dto.setId(0);
	            dto.setDescripcion(null);
	            dto.setNombre(null);
	            dto.setImagen(null);
	        }

	        return dto;
	    }

}