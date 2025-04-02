package com.monster.Monster.Hunter.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MonstruoMaterialDTO {

	private int id;
	private String nombre;
	private int probabilidad;
	private String imagen;
	private String nombreMonstruo;
}
