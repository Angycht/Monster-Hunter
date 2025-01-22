package com.monster.Monster.Hunter.service.mappers;

import com.monster.Monster.Hunter.persistence.entities.MonstruoMaterial;
import com.monster.Monster.Hunter.service.dto.MonstruoMaterialDTO;

public class MonstruoMaterialMapper {
	
	public static MonstruoMaterialDTO toDto (MonstruoMaterial material) {
		MonstruoMaterialDTO dto = new MonstruoMaterialDTO();
		dto.setImagen(material.getMaterial().getImagen());
		dto.setNombre(material.getMaterial().getRareza());
		dto.setRareza(material.getMaterial().getRareza());
		return dto;
	}

}
