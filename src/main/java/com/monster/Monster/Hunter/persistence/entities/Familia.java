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
@Table(name="familia")
@Getter
@Setter
@NoArgsConstructor 
public class Familia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INT", name = "ID_Familia")
	private int id;
	@Column(columnDefinition = "VARCHAR", length = 255, name = "Nombre" )
	private String nombre;
	@Column(columnDefinition = "TEXT", name = "Descripcion")
	private String descripcion;
	
	@OneToMany(mappedBy = "familia")
	@JsonIgnore
	private List<Monstruo> monstruos;
}
