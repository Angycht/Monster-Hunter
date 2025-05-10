package com.monster.Monster.Hunter.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.multipart.MultipartFile;

import com.monster.Monster.Hunter.persistence.entities.Monstruo;
import com.monster.Monster.Hunter.service.MonstruoService;
import com.monster.Monster.Hunter.service.dto.MonstruoDTO;
import com.monster.Monster.Hunter.service.dto.MonstruoMaterialDTO;

@RestController
@RequestMapping("/monstruos")
@CrossOrigin(origins = "http://localhost:4200")
public class MonstruoController {

	
	@Autowired
	private MonstruoService monstruoService;
	
	
	@GetMapping
	public ResponseEntity<List<MonstruoDTO>> listarMonstruos(){
		return ResponseEntity.ok(this.monstruoService.findAll());
	}
	
	@GetMapping("/{idMonstruo}")
	public ResponseEntity<MonstruoDTO> getMonstruoById(@PathVariable int idMonstruo){
		
		if(!this.monstruoService.existById(idMonstruo)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(this.monstruoService.findById(idMonstruo));
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
    public MonstruoDTO crearMonstruo(@RequestBody Monstruo monstruo,
                                        @RequestParam MultipartFile imagen) {
        return monstruoService.create( monstruo, imagen);
    }
	
	@PutMapping("/{idMonstruo}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<MonstruoDTO> actualizarMonstruo(@PathVariable int idMonstruo,@RequestBody Monstruo monstruo){
		if(idMonstruo != monstruo.getId()) {
			return ResponseEntity.badRequest().build();
		}
		if(!this.monstruoService.existById(idMonstruo)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(this.monstruoService.save(monstruo));
	}
	
	@DeleteMapping("/{idMonstruo}")
	@PreAuthorize("hasRole('ADMIN')")
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
	
	
	@PostMapping("/simular/{idMonstruo}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<MonstruoMaterialDTO>> simularCombate(@PathVariable int idMonstruo) {
	    List<MonstruoMaterialDTO> materiales = monstruoService.simularCombate(idMonstruo);
	    return ResponseEntity.ok(materiales);
	}
}
