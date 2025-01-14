package com.monster.Monster.Hunter.persistence.entities;

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
@Table(name="monstruo_material")
@NoArgsConstructor
public class MonstruoMaterial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_mostruo;
	
	private int id_material;
	
	private int probabilidad;

}
