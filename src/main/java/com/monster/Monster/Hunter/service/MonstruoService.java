package com.monster.Monster.Hunter.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monster.Monster.Hunter.persistence.entities.Monstruo;
import com.monster.Monster.Hunter.persistence.repository.MonstruoRepository;
import com.monster.Monster.Hunter.service.dto.MonstruoDTO;
import com.monster.Monster.Hunter.service.mappers.MonstruoMapper;

@Service
public class MonstruoService {

	@Autowired

	private MonstruoRepository monstruoRepository;

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
		
		
		return MonstruoMapper.toDto(this.monstruoRepository.save(monstruo));
	}

	public MonstruoDTO save(Monstruo monstruo) {
		return MonstruoMapper.toDto(this.monstruoRepository.save(monstruo));
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

}
