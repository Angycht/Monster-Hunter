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

import com.monster.Monster.Hunter.persistence.entities.MonstruoMaterial;
import com.monster.Monster.Hunter.service.MonstruoMaterialService;

@RestController
@RequestMapping("/monstruoMaterial")
public class MonstruoMaterialController {
	
	@Autowired
	private MonstruoMaterialService monstruoMaterialService;
	
	@GetMapping
	public ResponseEntity<List<MonstruoMaterial>> listarMonstruoMaterial(){
		return ResponseEntity.ok(this.monstruoMaterialService.findAll());
	}
	
	@GetMapping("/{idMonstruoMaterial}")
	public ResponseEntity<MonstruoMaterial> getMonstruoMaterialById(@PathVariable int idMonstruoMaterial){
		
		if(!this.monstruoMaterialService.existById(idMonstruoMaterial)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(this.monstruoMaterialService.findById(idMonstruoMaterial).get());
	}
	
	@PostMapping
	public ResponseEntity<MonstruoMaterial> crearMonstruoMaterial(@RequestBody MonstruoMaterial material){
		return new ResponseEntity<MonstruoMaterial>(this.monstruoMaterialService.create(material), HttpStatus.CREATED);
	}
	
	@PutMapping("/{idMonstruoMaterial}")
	public ResponseEntity<MonstruoMaterial> actualizarMonstruoMaterial(@PathVariable int idMonstruoMaterial,@RequestBody MonstruoMaterial monstruoMaterial){
		if(idMonstruoMaterial != monstruoMaterial.getId_material() ) {
			return ResponseEntity.badRequest().build();
		}
		if(!this.monstruoMaterialService.existById(idMonstruoMaterial)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(this.monstruoMaterialService.save(monstruoMaterial));
	}
	
	@DeleteMapping("/{idMonstruoMaterial}")
	public ResponseEntity<MonstruoMaterial> eliminarMonstruoMaterial(@PathVariable int idMonstruoMaterial){
		if(this.monstruoMaterialService.borrarId(idMonstruoMaterial)) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
