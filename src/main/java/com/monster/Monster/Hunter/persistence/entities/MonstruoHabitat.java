package com.monster.Monster.Hunter.persistence.entities;

import jakarta.persistence.Column;
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
@Table(name="monstruo_habitat")
@Getter
@Setter
@NoArgsConstructor
public class MonstruoHabitat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition = "INT", name = "ID_Monstruo")
	private int idMonstruo;
	@Column(columnDefinition = "INT", name = "ID_Habitat")
	private int idHabitat;
	
	@ManyToOne
	@JoinColumn(name = "ID_Monstruo", referencedColumnName = "ID_Monstruo", insertable = false, updatable = false)
	private Monstruo monstruo;
	
	@ManyToOne
	@JoinColumn(name = "ID_Habitat", referencedColumnName = "ID_Habitat", insertable = false, updatable = false)
	private Habitat habitat;

}
