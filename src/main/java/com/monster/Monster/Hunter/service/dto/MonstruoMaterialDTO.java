package com.monster.Monster.Hunter.service.dto;

import com.monster.Monster.Hunter.persistence.entities.MonstruoMaterial;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MonstruoMaterialDTO {

	  public MonstruoMaterialDTO(MonstruoMaterial material) {
	        this.id = material.getId();
	        this.nombre = material.getMaterial().getNombre();
	        this.probabilidad = material.getMaterial().getProbabilidad();
	        this.imagen = material.getMaterial().getImagen();
	        this.nombreMonstruo = material.getMonstruo().getNombre();
	    }
	private int id;
	private String nombre;
	private int probabilidad;
	private String imagen;
	private String nombreMonstruo;
}
