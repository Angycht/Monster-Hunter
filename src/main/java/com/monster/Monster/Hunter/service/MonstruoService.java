package com.monster.Monster.Hunter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monster.Monster.Hunter.persistence.entities.Monstruo;
import com.monster.Monster.Hunter.persistence.repository.MonstruoRepository;

@Service
public class MonstruoService {

	@Autowired

	private MonstruoRepository monstruoRepository;

	public List<Monstruo> findAll() {
		return this.monstruoRepository.findAll();
	}

	public Optional<Monstruo> findById(int idMonstruo) {
		return this.monstruoRepository.findById(idMonstruo);
	}

	public boolean existById(int idMonstruo) {
		return this.monstruoRepository.existsById(idMonstruo);
	}

	public Monstruo create(Monstruo monstruo) {
		return this.monstruoRepository.save(monstruo);
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
}
