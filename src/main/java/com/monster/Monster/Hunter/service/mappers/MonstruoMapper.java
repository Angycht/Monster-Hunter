package com.monster.Monster.Hunter.service.mappers;

import java.util.ArrayList;
import java.util.List;

import com.monster.Monster.Hunter.persistence.entities.Monstruo;
import com.monster.Monster.Hunter.persistence.entities.MonstruoHabitat;
import com.monster.Monster.Hunter.persistence.entities.MonstruoMaterial;
import com.monster.Monster.Hunter.service.dto.MonstruoDTO;
import com.monster.Monster.Hunter.service.dto.MonstruoHabitatDTO;
import com.monster.Monster.Hunter.service.dto.MonstruoMaterialDTO;

public class MonstruoMapper {

	public static MonstruoDTO toDto(Monstruo monstruo) {
		MonstruoDTO dto = new MonstruoDTO();
		dto.setId(monstruo.getId());
		dto.setNombre(monstruo.getNombre());
		dto.setDescripcion(monstruo.getDescripcion());
		dto.setPartesRompibles(monstruo.getPartesRompibles());
		dto.setFamilia(monstruo.getFamilia().getNombre());

		List<MonstruoHabitatDTO> monstruoHabitat = new ArrayList<MonstruoHabitatDTO>();

		for (MonstruoHabitat mh : monstruo.getMonstruoHabitat()) {
			monstruoHabitat.add(MonstruoHabitatMapper.toDto(mh));
		}

		dto.setMonstruoHabitatDto(monstruoHabitat);

		List<MonstruoMaterialDTO> monstruoMaterial = new ArrayList<MonstruoMaterialDTO>();

		for (MonstruoMaterial mm : monstruo.getMonstruoMaterial()) {
			monstruoMaterial.add(MonstruoMaterialMapper.toDto(mm));
		}

		dto.setMonstruoHabitatDto(monstruoHabitat);
		
		return dto;

	}
}
