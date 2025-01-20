package com.monster.Monster.Hunter.service.mappers;

import com.monster.Monster.Hunter.persistence.entities.MonstruoHabitat;
import com.monster.Monster.Hunter.service.dto.MonstruoHabitatDTO;

public class MonstruoHabitatMapper {
	
	public static MonstruoHabitatDTO toDto (MonstruoHabitat monstruoHabitat) {
		MonstruoHabitatDTO dto= new MonstruoHabitatDTO();
		dto.setDescripcion(monstruoHabitat.getIdHabitat());
		
	}

}
