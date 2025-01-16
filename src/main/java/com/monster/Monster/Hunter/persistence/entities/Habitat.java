package com.monster.Monster.Hunter.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="habitat")
@NoArgsConstructor
public class Habitat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INT", name = "ID_Habitat")
	private int id;
	@Column(columnDefinition = "VARCHAR", length = 255, name = "Nombre" )
	private String nombre;
	@Column(columnDefinition = "TEXT", name = "Descripcion")
	private String descripcion;
	@Column(columnDefinition = "VARCHAR", length = 255 , name = "Imagen")
	private String imagen;
	
	

}
