package com.monster.Monster.Hunter.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	
	public List<Material> findAll(){
		return this.materialRepository.findAll();
	}
	public Optional<Material> findById(int idMaterial){
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
		
		if(this.materialRepository.findById(idMaterial).isPresent()){
			this.materialRepository.deleteById(idMaterial);
			return true;
		}
		return false;
		
	}
	
	public List<Material> empiezaPor(String nombre){
		return this.materialRepository.findByNombreContaining(nombre);
	}
	  private static final Random random = new Random();

	    public Map<String, Object> simularCombate(int monsterId, int materialId) {
	        Material material = materialRepository.findById(materialId)
	                .orElseThrow(() -> new RuntimeException("Material no encontrado"));
	        
	        double probabilidadBase = material.getProbabilidad();
	        double resultado = random.nextDouble();
	        
	        boolean exito = resultado <= probabilidadBase;
	        
	        Map<String, Object> response = new HashMap<>();
	        response.put("resultado", exito ? "Éxito en la caza" : "Fallo en la caza");
	        response.put("exito", exito);
	        response.put("probabilidadUsada", probabilidadBase);
	        return response;
	    }
}
