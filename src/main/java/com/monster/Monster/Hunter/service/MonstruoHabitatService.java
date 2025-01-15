package com.monster.Monster.Hunter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monster.Monster.Hunter.persistence.entities.MonstruoHabitat;
import com.monster.Monster.Hunter.persistence.repository.MonstruoHabitatRepository;

@Service
public class MonstruoHabitatService {
	
	@Autowired
	private MonstruoHabitatRepository monstruoHabitatRepository;
	
	public List<MonstruoHabitat> findAll(){
		return this.monstruoHabitatRepository.findAll();
	}
	public Optional<MonstruoHabitat> findById(int idMonstruoHabitat){
		return this.monstruoHabitatRepository.findById(idMonstruoHabitat);
	}
	public boolean existById(int idMonstruoHabitat) {
		return this.monstruoHabitatRepository.existsById(idMonstruoHabitat);
	}
	public MonstruoHabitat create(MonstruoHabitat monstruoHabitat) {
		return this.monstruoHabitatRepository.save(monstruoHabitat);
	}
	public MonstruoHabitat save(MonstruoHabitat monstruoHabitat) {
		return this.monstruoHabitatRepository.save(monstruoHabitat);
	}
	public boolean borrarId(int idMonstruoHabitat) {
		
		if(this.monstruoHabitatRepository.findById(idMonstruoHabitat).isPresent()){
			this.monstruoHabitatRepository.deleteById(idMonstruoHabitat);
			return true;
		}
		return false;
		
	}

}
