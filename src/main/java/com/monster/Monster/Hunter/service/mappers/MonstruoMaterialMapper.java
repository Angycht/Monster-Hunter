package com.monster.Monster.Hunter.service.mappers;

import com.monster.Monster.Hunter.persistence.entities.Material;
import com.monster.Monster.Hunter.service.dto.MonstruoMaterialDTO;

public class MonstruoMaterialMapper {
	
	public static MonstruoMaterialDTO toDto (Material material) {
		MonstruoMaterialDTO dto = new MonstruoMaterialDTO();
		dto.setImagen(material.getImagen());
		dto.setNombre(material.getRareza());
		dto.setRareza(material.getRareza());
		return dto;
	}

}
