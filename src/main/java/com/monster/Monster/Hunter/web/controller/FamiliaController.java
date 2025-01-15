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

import com.monster.Monster.Hunter.persistence.entities.Familia;
import com.monster.Monster.Hunter.service.FamiliaService;


@RestController
@RequestMapping("/familia")
public class FamiliaController {

	

	@Autowired
	private FamiliaService familiaService;
	
	@GetMapping
	public ResponseEntity<List<Familia>> listarFamilias(){
		return ResponseEntity.ok(this.familiaService.findAll());
	}
	
	@GetMapping("/{idFamilia}")
	public ResponseEntity<Familia> getFamiliaById(@PathVariable int idFamilia){
		
		if(!this.familiaService.existById(idFamilia)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(this.familiaService.findById(idFamilia).get());
	}
	
	@PostMapping
	public ResponseEntity<Familia> crearFamilia(@RequestBody Familia familia){
		return new ResponseEntity<Familia>(this.familiaService.create(familia), HttpStatus.CREATED);
	}
	
	@PutMapping("/{idFamilia}")
	public ResponseEntity<Familia> actualizarFamilia(@PathVariable int idFamilia,@RequestBody Familia familia){
		if(idFamilia != familia.getId()) {
			return ResponseEntity.badRequest().build();
		}
		if(!this.familiaService.existById(idFamilia)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(this.familiaService.save(familia));
	}
	
	@DeleteMapping("/{idFamilia}")
	public ResponseEntity<Familia> eliminarFamilia(@PathVariable int idFamilia){
		if(this.familiaService.borrarId(idFamilia)) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
