package com.monster.Monster.Hunter.persistence.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="monstruo")
@NoArgsConstructor
public class Monstruo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INT", name = "ID_Monstruo")
	private int id;
	@Column(columnDefinition = "VARCHAR" , length = 255, name = "Nombre")
	private String nombre;
	@Column(columnDefinition = "TEXT",name = "Descripcion" )
	private String descripcion;
	@Column(columnDefinition = "VARCHAR", length = 255, name = "Partes_Rompibles")
	private String partesRompibles;
	@Column(columnDefinition = "VARCHAR", length = 255, name = "Imagen")
	private String imagen;
	
	
	@ManyToOne
	@JoinColumn(name="ID_Familia", referencedColumnName = "ID_Familia", insertable = false, updatable = false)
	private Familia familia;

	@OneToMany(mappedBy = "monstruo")
	@JsonIgnore
	private List<MonstruoMaterial> monstruoMaterial;
	
	@OneToMany(mappedBy = "habitat")
	@JsonIgnore
	private List<MonstruoHabitat> monstruoHabitat;

}
