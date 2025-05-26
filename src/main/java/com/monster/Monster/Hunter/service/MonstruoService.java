package com.monster.Monster.Hunter.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monster.Monster.Hunter.persistence.entities.Monstruo;
import com.monster.Monster.Hunter.persistence.entities.MonstruoMaterial;
import com.monster.Monster.Hunter.persistence.repository.FamiliaRepository;
import com.monster.Monster.Hunter.persistence.repository.MonstruoRepository;
import com.monster.Monster.Hunter.service.dto.MonstruoDTO;
import com.monster.Monster.Hunter.service.dto.MonstruoMaterialDTO;
import com.monster.Monster.Hunter.service.mappers.MonstruoMapper;

@Service
public class MonstruoService {

	@Autowired
	private MonstruoRepository monstruoRepository;
	
	@Autowired
	private FamiliaRepository familiaRepository;

	public List<MonstruoDTO> findAll() {
		
		List<MonstruoDTO> monstruosDTO = new ArrayList<MonstruoDTO>();

		for (Monstruo m : this.monstruoRepository.findAll()) {
			monstruosDTO.add(MonstruoMapper.toDto(m));
		}

		return monstruosDTO;
	}

	public MonstruoDTO findById(int idMonstruo) {
		return MonstruoMapper.toDto(this.monstruoRepository.findById(idMonstruo).get());
	}

	public boolean existById(int idMonstruo) {
		return this.monstruoRepository.existsById(idMonstruo);
	}

	public MonstruoDTO create(Monstruo monstruo) {
		
		monstruo.setFamilia(familiaRepository.findById(monstruo.getFamiliaId()).orElse(null));
		return MonstruoMapper.toDto(this.monstruoRepository.save(monstruo));
	}

	public Monstruo save(Monstruo monstruo) {
		return this.monstruoRepository.save(monstruo);
	}

	public boolean borrarId(int idMonstruo) {

		if (this.monstruoRepository.findById(idMonstruo).isPresent()) {
			this.monstruoRepository.deleteById(idMonstruo);
			return true;
		}
		return false;

	}

	public List<Monstruo> empiezaPor(String nombre) {
		return this.monstruoRepository.findByNombreContaining(nombre);

	}
	public List<MonstruoMaterialDTO> simularCombate(int idMonstruo) {
	    Monstruo monstruo = monstruoRepository.findById(idMonstruo)
	        .orElseThrow(() -> new RuntimeException("Monstruo no encontrado"));

	    List<MonstruoMaterial> materiales = monstruo.getMonstruoMaterial();

	    if (materiales == null || materiales.isEmpty()) {
	        throw new RuntimeException("El monstruo no tiene materiales asociados");
	    }

	  
	    int cantidad = Math.min(3, materiales.size());

	    List<MonstruoMaterialDTO> copia = new ArrayList<>();
	    for (MonstruoMaterial mat : materiales) {
	        copia.add(new MonstruoMaterialDTO(mat)); 
	    }

	    Collections.shuffle(copia);
	    List<MonstruoMaterialDTO> resultado = new ArrayList<>();
	    for (int i = 0; i < cantidad; i++) {
	        resultado.add(copia.get(i));
	    }

	    return resultado;
	}
}
