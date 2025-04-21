package com.monster.Monster.Hunter.service.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FamiliaDetalleDTO {
	
	   public FamiliaDetalleDTO(int id, String nombre, String descripcion, String imagen, List<MonstruoDTO> monstruos) {
	        this.id = id;
	        this.nombre = nombre;
	        this.descripcion = descripcion;
	        this.imagen = imagen;
	        this.monstruos = monstruos;
	    }
	private int id;
    private String nombre;
    private String descripcion;
    private String imagen;
    private List<MonstruoDTO> monstruos;
}
