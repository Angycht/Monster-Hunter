package com.monster.Monster.Hunter.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="monstruo_material")
@NoArgsConstructor
public class MonstruoMaterial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMostruo;
	
	private int idMaterial;
	
	private int probabilidad;
	
	@ManyToOne
	@JoinColumn(name = "idMonstruo", referencedColumnName = "id", insertable = false, updatable = false)
	private Monstruo monstruo;
	
	@ManyToOne
	@JoinColumn(name = "idMaterial", referencedColumnName = "id", insertable = false, updatable = false)
	private Material material;

}
