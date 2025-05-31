package com.monster.Monster.Hunter.web.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monster.Monster.Hunter.persistence.entities.Habitat;
import com.monster.Monster.Hunter.service.HabitatService;
import com.monster.Monster.Hunter.service.dto.MonstruoDTO;

@RestController
@RequestMapping("/habitats")
@CrossOrigin(origins = "http://localhost:4200")
public class HabitatController {

	@Autowired
	private HabitatService habitatService;

	@GetMapping
	public ResponseEntity<List<Habitat>> listarHabitat() {
		return ResponseEntity.ok(this.habitatService.findAll());
	}

	@GetMapping("/{id}/monstruos")
	public ResponseEntity<List<MonstruoDTO>> getMonstruosByHabitat(@PathVariable int id) {
	    Optional<List<Habitat>> optionalHabitat = habitatService.buscarMonstruo(id);
	    if (optionalHabitat.isEmpty() || optionalHabitat.get().isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }
	    Habitat habitat = optionalHabitat.get().get(0); // Toma el primer hábitat

	    List<MonstruoDTO> monstruos = habitat.getMonstruoHabitats().stream()
	        .map(mh -> new MonstruoDTO(mh.getMonstruo().getId(), mh.getMonstruo().getNombre()))
	        .collect(Collectors.toList());

	    return ResponseEntity.ok(monstruos);
	}
	@GetMapping("/{idHabitat}")
	public ResponseEntity<Habitat> getHabitatById(@PathVariable int idHabitat) {

		if (!this.habitatService.existById(idHabitat)) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(this.habitatService.findById(idHabitat).get());
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Habitat> crearHabitat(@RequestBody Habitat habitat) {
		return new ResponseEntity<Habitat>(this.habitatService.create(habitat), HttpStatus.CREATED);
	}

	@PutMapping("/{idHabitat}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Habitat> actualizaHabitat(@PathVariable int idHabitat, @RequestBody Habitat habitat) {
		if (idHabitat != habitat.getId()) {
			return ResponseEntity.badRequest().build();
		}
		if (!this.habitatService.existById(idHabitat)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(this.habitatService.save(habitat));
	}

	@DeleteMapping("/{idHabitat}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Habitat> eliminarHabitat(@PathVariable int idHabitat) {
		if (this.habitatService.borrarId(idHabitat)) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

	@GetMapping("/buscar")
	public ResponseEntity<List<Habitat>> buscar(@RequestParam String nombre) {
		return ResponseEntity.ok(this.habitatService.empiezaPor(nombre));
	}

}
