package com.monster.Monster.Hunter.persistence.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="material")
@NoArgsConstructor
public class Material {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INT", name = "ID_Material")
	private int id;
	@Column(columnDefinition = "VARCHAR",length = 255, name = "Nombre")
	private String nombre;
	@Column(columnDefinition = "VARCHAR",length = 50, name = "Rareza")
	private String rareza;
	@Column(columnDefinition = "VARCHAR", length = 255, name = "Imagen")
	private String imagen;
	

	@OneToMany(mappedBy= "material")
	@JsonIgnore
	private List<MonstruoMaterial> monstruoMaterial;
}
