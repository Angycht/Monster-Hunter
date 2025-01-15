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
import com.monster.Monster.Hunter.persistence.entities.Material;
import com.monster.Monster.Hunter.service.MaterialService;

@RestController
@RequestMapping("/material")
public class MaterialController {

	
	@Autowired
	private MaterialService materialService;
	
	@GetMapping
	public ResponseEntity<List<Material>> listarMaterial(){
		return ResponseEntity.ok(this.materialService.findAll());
	}
	
	@GetMapping("/{idMaterial}")
	public ResponseEntity<Material> getMaterialById(@PathVariable int idMaterial){
		
		if(!this.materialService.existById(idMaterial)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(this.materialService.findById(idMaterial).get());
	}
	
	@PostMapping
	public ResponseEntity<Material> crearMaterial(@RequestBody Material material){
		return new ResponseEntity<Material>(this.materialService.create(material), HttpStatus.CREATED);
	}
	
	@PutMapping("/{idMaterial}")
	public ResponseEntity<Material> actualizarMaterial(@PathVariable int idMaterial,@RequestBody Material material){
		if(idMaterial != material.getId()) {
			return ResponseEntity.badRequest().build();
		}
		if(!this.materialService.existById(idMaterial)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(this.materialService.save(material));
	}
	
	@DeleteMapping("/{idMaterial}")
	public ResponseEntity<Familia> eliminarMaterial(@PathVariable int idMaterial){
		if(this.materialService.borrarId(idMaterial)) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
