package com.monster.Monster.Hunter.service;

import java.util.List;
import java.util.Optional;

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
}
