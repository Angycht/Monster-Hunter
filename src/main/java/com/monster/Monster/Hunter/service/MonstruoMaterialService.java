package com.monster.Monster.Hunter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monster.Monster.Hunter.persistence.entities.MonstruoMaterial;
import com.monster.Monster.Hunter.persistence.repository.MonstruoMaterialRepository;
import com.monster.Monster.Hunter.service.dto.MonstruoMaterialDTO;
import com.monster.Monster.Hunter.service.mappers.MonstruoMaterialMapper;

@Service
public class MonstruoMaterialService {
	
	@Autowired
	
	private MonstruoMaterialRepository monstruoMaterialRepository;
	
	public List<MonstruoMaterialDTO> findAll(){
		
		List<MonstruoMaterialDTO> monstruoMaterialDTO= new ArrayList<MonstruoMaterialDTO>();
		for(MonstruoMaterial mm : this.monstruoMaterialRepository.findAll()) {
			monstruoMaterialDTO.add(MonstruoMaterialMapper.toDto(mm));
			
		}
		
		return monstruoMaterialDTO;
	}
	public MonstruoMaterialDTO findById(int idMonstruoMaterial){
		return MonstruoMaterialMapper.toDto(this.monstruoMaterialRepository.findById(idMonstruoMaterial).get()) ;
	}
	public boolean existById(int idMonstruoMaterial) {
		return this.monstruoMaterialRepository.existsById(idMonstruoMaterial);
	}
	public MonstruoMaterialDTO create(MonstruoMaterial monstruoMaterial) {
		monstruoMaterial=this.monstruoMaterialRepository.save(monstruoMaterial);
		return MonstruoMaterialMapper.toDto(monstruoMaterial);
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
