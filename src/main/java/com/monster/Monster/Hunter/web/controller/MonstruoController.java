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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monster.Monster.Hunter.persistence.entities.Monstruo;
import com.monster.Monster.Hunter.service.MonstruoService;

@RestController
@RequestMapping("/monstruos")
public class MonstruoController {

	
	@Autowired
	private MonstruoService monstruoService;
	
	@GetMapping
	public ResponseEntity<List<Monstruo>> listarMonstruos(){
		return ResponseEntity.ok(this.monstruoService.findAll());
	}
	
	@GetMapping("/{idMonstruo}")
	public ResponseEntity<Monstruo> getMonstruoById(@PathVariable int idMonstruo){
		
		if(!this.monstruoService.existById(idMonstruo)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(this.monstruoService.findById(idMonstruo).get());
	}
	
	@PostMapping
	public ResponseEntity<Monstruo> crearMonstruo(@RequestBody Monstruo monstruo){
		return new ResponseEntity<Monstruo>(this.monstruoService.create(monstruo), HttpStatus.CREATED);
	}
	
	@PutMapping("/{idMonstruo}")
	public ResponseEntity<Monstruo> actualizarMonstruo(@PathVariable int idMonstruo,@RequestBody Monstruo monstruo){
		if(idMonstruo != monstruo.getId()) {
			return ResponseEntity.badRequest().build();
		}
		if(!this.monstruoService.existById(idMonstruo)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(this.monstruoService.save(monstruo));
	}
	
	@DeleteMapping("/{idMonstruo}")
	public ResponseEntity<Monstruo> eliminarMonstruo(@PathVariable int idMonstruo){
		if(this.monstruoService.borrarId(idMonstruo)) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<List<Monstruo>> buscar(@RequestParam String nombre){
		return ResponseEntity.ok(this.monstruoService.empiezaPor(nombre));
	}
}
