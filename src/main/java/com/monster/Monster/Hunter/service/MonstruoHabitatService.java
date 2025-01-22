package com.monster.Monster.Hunter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monster.Monster.Hunter.persistence.entities.MonstruoHabitat;
import com.monster.Monster.Hunter.persistence.repository.MonstruoHabitatRepository;
import com.monster.Monster.Hunter.service.dto.MonstruoHabitatDTO;
import com.monster.Monster.Hunter.service.mappers.MonstruoHabitatMapper;

@Service
public class MonstruoHabitatService {
	
	@Autowired
	private MonstruoHabitatRepository monstruoHabitatRepository;
	
	public List<MonstruoHabitatDTO> findAll(){
		
		List<MonstruoHabitatDTO> monstruoHabitatDTO= new ArrayList<MonstruoHabitatDTO>();
		
		for(MonstruoHabitat mh : this.monstruoHabitatRepository.findAll()) {
			
			monstruoHabitatDTO.add(MonstruoHabitatMapper.toDto(mh));
		}
		return monstruoHabitatDTO;
	}
	public MonstruoHabitatDTO findById(int idMonstruoHabitat){
		return MonstruoHabitatMapper.toDto(this.monstruoHabitatRepository.findById(idMonstruoHabitat).get()) ;
	}
	public boolean existById(int idMonstruoHabitat) {
		return this.monstruoHabitatRepository.existsById(idMonstruoHabitat);
	}
	public MonstruoHabitatDTO create(MonstruoHabitat monstruoHabitat) {
		return MonstruoHabitatMapper.toDto(this.monstruoHabitatRepository.save(monstruoHabitat));
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
