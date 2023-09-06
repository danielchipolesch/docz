package br.com.docz.controller;

import br.com.docz.dto.AssuntoBasicoDto;
import br.com.docz.exception.AssuntoBasicoException;
import br.com.docz.model.entity.AssuntoBasico;
import br.com.docz.service.AssuntoBasicoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/assunto-basico")
@CrossOrigin(origins = "*")
public class AssuntoBasicoController {
	
	@Autowired
	AssuntoBasicoService assuntoBasicoService;
	
	
	@PostMapping()
	public ResponseEntity<Object> criar(@RequestBody @Valid AssuntoBasicoDto assuntoBasicoDto) {
		try {
			var assuntoBasicoModel = new AssuntoBasico();
			BeanUtils.copyProperties(assuntoBasicoDto, assuntoBasicoModel);
			return ResponseEntity.status(HttpStatus.CREATED).body(assuntoBasicoService.criar(assuntoBasicoModel));
		} catch (RuntimeException runtimeException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
		}
	}
	
	@GetMapping()
	public ResponseEntity<Object> listarTodos(AssuntoBasicoDto assuntoBasicoDto){
		try {
			var assuntoBasicoModel = new AssuntoBasico();
			BeanUtils.copyProperties(assuntoBasicoDto, assuntoBasicoModel);
			return ResponseEntity.status(HttpStatus.OK).body(assuntoBasicoService.listarTodos(assuntoBasicoModel));
		} catch (RuntimeException runtimeException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> listarPorId(@PathVariable(value = "id") Integer id){
		if (id == null){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(AssuntoBasicoException.parameterNotNull());
		}
		Optional<AssuntoBasico> assuntoBasico = assuntoBasicoService.listarPorId(id);
		return assuntoBasico.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(AssuntoBasicoException.objectNotFound()) : ResponseEntity.status(HttpStatus.OK).body(assuntoBasico.get());
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Integer id,
											@RequestBody @Valid AssuntoBasicoDto assuntoBasicoDto){
		
		Optional<AssuntoBasico> assuntoBasico = assuntoBasicoService.listarPorId(id);
		
		if (assuntoBasico.isPresent()){
			var assuntoBasicoModel = assuntoBasico.get();
			
			try {
				BeanUtils.copyProperties(assuntoBasicoDto, assuntoBasicoModel);
				return ResponseEntity.status(HttpStatus.OK).body(assuntoBasicoService.atualizar(assuntoBasicoModel));
			} catch (RuntimeException runtimeException) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(AssuntoBasicoException.objectNotFound());
		}
		
		
	}
	
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Object> deletar(@PathVariable(value = "id") Integer id){
		Optional<AssuntoBasico> assuntoBasico = assuntoBasicoService.listarPorId(id);
		if (assuntoBasico.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(AssuntoBasicoException.objectNotFound());
		}
		
		try {
			assuntoBasicoService.deletar(id);
			return ResponseEntity.status(HttpStatus.OK).body("Assunto básico deletado com sucesso!");
		} catch (RuntimeException runtimeException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
		}

	}
	
}
