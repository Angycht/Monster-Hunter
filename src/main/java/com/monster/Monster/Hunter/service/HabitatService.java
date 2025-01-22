package com.monster.Monster.Hunter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monster.Monster.Hunter.persistence.entities.Habitat;
import com.monster.Monster.Hunter.persistence.repository.HabitatRepository;

@Service
public class HabitatService {
	
	@Autowired
	private HabitatRepository habitatRepository;
	
	public List<Habitat> findAll(){
		return this.habitatRepository.findAll();
	}
	public Optional<Habitat> findById(int idHabitat){
		return this.habitatRepository.findById(idHabitat);
	}
	public boolean existById(int idHabitat) {
		return this.habitatRepository.existsById(idHabitat);
	}
	public Habitat create(Habitat habitat) {
		return this.habitatRepository.save(habitat);
	}
	public Habitat save(Habitat habitat) {
		return this.habitatRepository.save(habitat);
	}
	public boolean borrarId(int idHabitat) {
		
		if(this.habitatRepository.findById(idHabitat).isPresent()){
			this.habitatRepository.deleteById(idHabitat);
			return true;
		}
		return false;
		
	}
	public List<Habitat> empiezaPor (String nombre){
		return this.habitatRepository.findByNombreContaining(nombre);
	}

}
