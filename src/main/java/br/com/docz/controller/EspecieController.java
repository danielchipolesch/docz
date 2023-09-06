package br.com.docz.controller;

import br.com.docz.dto.EspecieDto;
import br.com.docz.exception.EspecieException;
import br.com.docz.model.entity.Especie;
import br.com.docz.service.EspecieService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/especie")
@CrossOrigin(origins = "*")
public class EspecieController {
	
	@Autowired
	EspecieService especieService;
	
	@PostMapping()
	public ResponseEntity<Object> criar (@RequestBody EspecieDto especieDto){
		try {
			var especieModel = new Especie();
			BeanUtils.copyProperties(especieDto, especieModel);
			return ResponseEntity.status(HttpStatus.CREATED).body(especieService.criar(especieModel));
		} catch (RuntimeException runtimeException){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
		}
	}
	@GetMapping()
	public ResponseEntity<Object> listarTodos(EspecieDto especieDto){
		try {
			var especieModel = new Especie();
			BeanUtils.copyProperties(especieDto, especieModel);
			return ResponseEntity.status(HttpStatus.OK).body(especieService.listarTodos(especieModel));
		} catch (RuntimeException runtimeException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> listarPorId(@PathVariable(value = "id") Integer id){
		Optional<Especie> especie = especieService.listarPorId(id);
		return especie.isEmpty() ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(EspecieException.objectNotFound()) : ResponseEntity.status(HttpStatus.OK).body(especie.get());
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Integer id,
	                                        @RequestBody EspecieDto especieDto){
		
		Optional<Especie> especie = especieService.listarPorId(id);
		
		if (especie.isEmpty()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(EspecieException.parameterNotNull());
		}
		try {
			var especieModel = especie.get();
			BeanUtils.copyProperties(especieDto, especieModel);
			return ResponseEntity.status(HttpStatus.OK).body(especieService.atualizar(especieModel));
		} catch (RuntimeException runtimeException){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
		}
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Object> deletar(@PathVariable(value = "id") Integer id){
		Optional<Especie> especie = especieService.listarPorId(id);
		if (especie.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(EspecieException.objectNotFound());
		}
		
		try {
			especieService.deletar(id);
			return ResponseEntity.status(HttpStatus.OK).body("Espécie deletada com sucesso!");
		} catch (RuntimeException runtimeException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
		}
	}
}
