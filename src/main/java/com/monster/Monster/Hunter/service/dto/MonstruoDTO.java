package com.monster.Monster.Hunter.service.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MonstruoDTO {
	
	
	 public MonstruoDTO(int id, String nombre) {
	        this.id = id;
	        this.nombre = nombre;
	    }
	private int id;
	private String nombre;
	private String descripcion;
	private String partesRompibles;
	private String imagen;
	private String familia;
	
	private List<MonstruoHabitatDTO> monstruoHabitatDto;
	private List<MonstruoMaterialDTO> monstruoMaterialDto;

	
}
