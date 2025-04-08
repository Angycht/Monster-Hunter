package com.monster.Monster.Hunter.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monster.Monster.Hunter.persistence.entities.Material;
import com.monster.Monster.Hunter.persistence.repository.MaterialRepository;

@Service
public class MaterialService {

	@Autowired
	private MaterialRepository materialRepository;

	public List<Material> findAll() {
		return this.materialRepository.findAll();
	}

	public Optional<Material> findById(int idMaterial) {
		return this.materialRepository.findById(idMaterial);
	}

	public boolean existById(int idMaterial) {
		return this.materialRepository.existsById(idMaterial);
	}

	public Material create(Material material) {
		return this.materialRepository.save(material);
	}

	public Material save(Material material) {
		return this.materialRepository.save(material);
	}

	public boolean borrarId(int idMaterial) {

		if (this.materialRepository.findById(idMaterial).isPresent()) {
			this.materialRepository.deleteById(idMaterial);
			return true;
		}
		return false;

	}

	public List<Material> empiezaPor(String nombre) {
		return this.materialRepository.findByNombreContaining(nombre);
	}

	private static final Random random = new Random();

	public String simularCombate(int materialId) {
		    Optional<Material> material = this.findById(materialId);
		    
		    if(this.findById(materialId).isPresent()) {
		    	material.get();
		    	int probabilidadBase = material.get().getProbabilidad(); // Probabilidad del 0 al 100
			    double probabilidad = probabilidadBase / 100.0; // Convertir a decimal

			    int intentos = 0;
			    boolean conseguido = false;

			    while (!conseguido) {
			        intentos++;
			        double resultado = random.nextDouble(); // Valor entre 0.0 y 1.0
			        if (resultado <= probabilidad) {
			            conseguido = true;
			        }
			    }

			    String mensaje= "Material conseguido después de " + intentos + " intento(s) con una probabilidad de " + probabilidadBase + "%.";
			    return mensaje ;
			
		    }
		    if(!this.existById(materialId)) {
		    	String mensaje="Material no encontrado";
		    	return mensaje;
		    }
			return null;
		    
	}
		  
		    
}
