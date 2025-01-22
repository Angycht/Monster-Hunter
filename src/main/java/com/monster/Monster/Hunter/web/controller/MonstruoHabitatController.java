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

import com.monster.Monster.Hunter.persistence.entities.MonstruoHabitat;
import com.monster.Monster.Hunter.service.MonstruoHabitatService;
import com.monster.Monster.Hunter.service.dto.MonstruoHabitatDTO;

@RestController
@RequestMapping("/monstruoHabitat")
public class MonstruoHabitatController {

	
	@Autowired
	private MonstruoHabitatService monstruohabitatService;
	
	@GetMapping
	public ResponseEntity<List<MonstruoHabitatDTO>> listarHabitat(){
		return ResponseEntity.ok(this.monstruohabitatService.findAll());
	}
	
	@GetMapping("/{idHabitat}")
	public ResponseEntity<MonstruoHabitatDTO> getHabitatById(@PathVariable int idMonstruoHabitat){
		
		if(!this.monstruohabitatService.existById(idMonstruoHabitat)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(this.monstruohabitatService.findById(idMonstruoHabitat)) ;
	}
	
	@PostMapping
	public ResponseEntity<MonstruoHabitatDTO> crearHabitat(@RequestBody MonstruoHabitat monstruoHabitat){
		return new ResponseEntity<MonstruoHabitatDTO>(this.monstruohabitatService.create(monstruoHabitat), HttpStatus.CREATED);
	}
	
	@PutMapping("/{idMonstruoHabitat}")
	public ResponseEntity<MonstruoHabitat> actualizaHabitat(@PathVariable int idMonstruoHabitat,@RequestBody MonstruoHabitat monstruoHabitat){
		if(idMonstruoHabitat != monstruoHabitat.getIdMonstruo() ) {
			return ResponseEntity.badRequest().build();
		}
		if(!this.monstruohabitatService.existById(idMonstruoHabitat)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(this.monstruohabitatService.save(monstruoHabitat));
	}
	
	@DeleteMapping("/{idMonstruoHabitat}")
	public ResponseEntity<MonstruoHabitat> eliminarHabitat(@PathVariable int idMonstruoHabitat){
		if(this.monstruohabitatService.borrarId(idMonstruoHabitat)) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
