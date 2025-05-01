package com.monster.Monster.Hunter.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.monster.Monster.Hunter.persistence.entities.Monstruo;
import com.monster.Monster.Hunter.persistence.entities.MonstruoMaterial;
import com.monster.Monster.Hunter.persistence.repository.MonstruoRepository;
import com.monster.Monster.Hunter.service.dto.MonstruoDTO;
import com.monster.Monster.Hunter.service.dto.MonstruoMaterialDTO;
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

	public MonstruoDTO create(Monstruo monstruo,MultipartFile imagen) {
		
		
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
	public List<MonstruoMaterialDTO> simularCombate(int idMonstruo) {
	    // Busca el monstruo
	    Monstruo monstruo = monstruoRepository.findById(idMonstruo)
	        .orElseThrow(() -> new RuntimeException("Monstruo no encontrado"));

	    List<MonstruoMaterial> materiales = monstruo.getMonstruoMaterial();

	    if (materiales == null || materiales.isEmpty()) {
	        throw new RuntimeException("El monstruo no tiene materiales asociados");
	    }

	    // Decide cuántos materiales quieres soltar (por ejemplo, 3 al azar)
	    int cantidad = Math.min(3, materiales.size());

	    // Llena la lista copia con los DTOs de los materiales
	    List<MonstruoMaterialDTO> copia = new ArrayList<>();
	    for (MonstruoMaterial mat : materiales) {
	        copia.add(new MonstruoMaterialDTO(mat)); // Ajusta el constructor según tu DTO
	    }

	    // Baraja la lista
	    Collections.shuffle(copia);

	    // Selecciona los primeros 'cantidad' materiales
	    List<MonstruoMaterialDTO> resultado = new ArrayList<>();
	    for (int i = 0; i < cantidad; i++) {
	        resultado.add(copia.get(i));
	    }

	    return resultado;
	}
}
