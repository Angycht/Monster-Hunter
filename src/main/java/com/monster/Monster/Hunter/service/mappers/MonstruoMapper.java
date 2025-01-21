package com.monster.Monster.Hunter.service.mappers;

import com.monster.Monster.Hunter.persistence.entities.Monstruo;
import com.monster.Monster.Hunter.service.dto.MonstruoDTO;

public class MonstruoMapper {

	public static MonstruoDTO toDto(Monstruo monstruo) {
		MonstruoDTO dto = new MonstruoDTO();
		dto.setId(monstruo.getId());
		dto.setNombre(monstruo.getNombre());
		dto.setDescripcion(monstruo.getDescripcion());
		dto.setPartesRompibles(monstruo.getPartesRompibles());
		dto.setFamilia(monstruo.getFamilia().getNombre());
		/*
		 * 
		 * Meter los materiales 
		 */

		return dto;
	}
}
