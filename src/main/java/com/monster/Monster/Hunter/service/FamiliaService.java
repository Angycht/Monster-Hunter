package com.monster.Monster.Hunter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monster.Monster.Hunter.persistence.entities.Familia;
import com.monster.Monster.Hunter.persistence.repository.FamiliaRepository;
import com.monster.Monster.Hunter.service.dto.FamiliaDetalleDTO;
import com.monster.Monster.Hunter.service.dto.MonstruoDTO;
@Service
public class FamiliaService {

	
	@Autowired
	
	private FamiliaRepository familiaRepository;
	
	public List<Familia> findAll(){
		return this.familiaRepository.findAll();
	}
	public Optional<Familia> findById(int idFamilia){
		return this.familiaRepository.findById(idFamilia);
	}
	public boolean existById(int idFamilia) {
		return this.familiaRepository.existsById(idFamilia);
	}
	public Familia create(Familia familia) {
		return this.familiaRepository.save(familia);
	}
	public Familia save(Familia familia) {
		return this.familiaRepository.save(familia);
	}
	public boolean borrarId(int idFamilia) {
		
		if(this.familiaRepository.findById(idFamilia).isPresent()){
			this.familiaRepository.deleteById(idFamilia);
			return true;
		}
		return false;
		
	}
	public List<Familia> empiezaPor (String nombre){
		return this.familiaRepository.findByNombreContaining(nombre);
	}
	public FamiliaDetalleDTO getFamiliaDetalle(int id) {
	    Familia familia = familiaRepository.findByIdWithMonstruos(id)
	        .orElseThrow(() -> new IllegalArgumentException("Familia no encontrada"));

	    return new FamiliaDetalleDTO(
	        familia.getId(),
	        familia.getNombre(),
	        familia.getDescripcion(),
	        familia.getImagen(),
	        familia.getMonstruos().stream()
	            .map(m -> new MonstruoDTO(m.getId(), m.getNombre()))
	            .toList()
	    );
	}
}
