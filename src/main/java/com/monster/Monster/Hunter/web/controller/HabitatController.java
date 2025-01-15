package com.monster.Monster.Hunter.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monster.Monster.Hunter.persistence.entities.Habitat;
import com.monster.Monster.Hunter.service.HabitatService;

@RestController
@RequestMapping("/habitat")
public class HabitatController {
	

	@Autowired
	private HabitatService habitatService;
	
	@GetMapping
	public ResponseEntity<List<Habitat>> listarHabitat(){
		return ResponseEntity.ok(this.habitatService.findAll());
	}
	
	@GetMapping("/{idHabitat}")
	public ResponseEntity<Habitat> getHabitatById(@PathVariable int idHabitat){
		
		if(!this.habitatService.existById(idHabitat)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(this.habitatService.findById(idHabitat).get());
	}
	
	@PostMapping
	public ResponseEntity<Habitat> crearHabitat(@RequestBody Habitat habitat){
		return new ResponseEntity<Habitat>(this.habitatService.create(habitat), HttpStatus.CREATED);
	}
	
	@PutMapping("/{idHabitat}")
	public ResponseEntity<Habitat> actualizaHabitat(@PathVariable int idHabitat,@RequestBody Habitat habitat){
		if(idHabitat != habitat.getId() ) {
			return ResponseEntity.badRequest().build();
		}
		if(!this.habitatService.existById(idHabitat)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(this.habitatService.save(habitat));
	}
	
	@DeleteMapping("/{idHabitat}")
	public ResponseEntity<Habitat> eliminarHabitat(@PathVariable int idHabitat){
		if(this.habitatService.borrarId(idHabitat)) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
