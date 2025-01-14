package com.monster.Monster.Hunter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monster.Monster.Hunter.persistence.entities.MonstruoMaterial;
import com.monster.Monster.Hunter.persistence.repository.MonstruoMaterialRepository;

@Service
public class MonstruoMaterialService {
	
	@Autowired
	
	private MonstruoMaterialRepository monstruoMaterialRepository;
	
	public List<MonstruoMaterial> findAll(){
		return this.monstruoMaterialRepository.findAll();
	}
	public Optional<MonstruoMaterial> findById(int idMonstruoMaterial){
		return this.monstruoMaterialRepository.findById(idMonstruoMaterial);
	}
	public boolean existById(int idMonstruoMaterial) {
		return this.monstruoMaterialRepository.existsById(idMonstruoMaterial);
	}
	public MonstruoMaterial create(MonstruoMaterial monstruoMaterial) {
		return this.monstruoMaterialRepository.save(monstruoMaterial);
	}
	public MonstruoMaterial save(MonstruoMaterial monstruoMaterial) {
		return this.monstruoMaterialRepository.save(monstruoMaterial);
	}
	public boolean borrarId(int idMonstruoMaterial) {
		
		if(this.monstruoMaterialRepository.findById(idMonstruoMaterial).isPresent()){
			this.monstruoMaterialRepository.deleteById(idMonstruoMaterial);
			return true;
		}
		return false;
		
	}

}
