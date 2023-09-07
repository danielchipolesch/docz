package br.com.docz.controller;

import br.com.docz.dto.ReferenciaDto;
import br.com.docz.exception.ReferenciaException;
import br.com.docz.model.entity.Referencia;
import br.com.docz.service.ReferenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/referencia")
@CrossOrigin(origins = "*")
public class ReferenciaController {
	
	@Autowired
	ReferenciaService referenciaService;
	
//	@PostMapping()
//	public ResponseEntity<Object> criar (@RequestBody @Valid ReferenciaDto referenciaDto){
//		try {
//			var referenciaModel = new Referencia();
//			BeanUtils.copyProperties(referenciaDto, referenciaModel);
//			return ResponseEntity.status(HttpStatus.CREATED).body(referenciaService.criar());
//		} catch (RuntimeException runtimeException){
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
//		}
//	}
	@GetMapping()
	public ResponseEntity<Object> listarTodos(ReferenciaDto referenciaDto){
		try {
			var referenciaModel = new Referencia();
			BeanUtils.copyProperties(referenciaDto, referenciaModel);
			return ResponseEntity.status(HttpStatus.OK).body(referenciaService.listarTodos(referenciaModel));
		} catch (RuntimeException runtimeException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> listarPorId(@PathVariable(value = "id") Integer id){
		Optional<Referencia> referencia = referenciaService.listarPorId(id);
		return referencia.isEmpty() ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ReferenciaException.objectNotFound()) : ResponseEntity.status(HttpStatus.OK).body(referencia.get());
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Integer id,
	                                        @RequestBody @Valid ReferenciaDto referenciaDto){
		
		Optional<Referencia> referencia = referenciaService.listarPorId(id);
		
		if (referencia.isEmpty()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ReferenciaException.parameterNotNull());
		}
		try {
			var referenciaModel = referencia.get();
			BeanUtils.copyProperties(referenciaDto, referenciaModel);
			return ResponseEntity.status(HttpStatus.OK).body(referenciaService.atualizar(referenciaModel));
		} catch (RuntimeException runtimeException){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
		}
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Object> deletar(@PathVariable(value = "id") Integer id){
		Optional<Referencia> referencia = referenciaService.listarPorId(id);
		if (referencia.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ReferenciaException.objectNotFound());
		}
		
		try {
			referenciaService.deletar(id);
			return ResponseEntity.status(HttpStatus.OK).body("Referência deletada com sucesso!");
		} catch (RuntimeException runtimeException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
		}
	}
}
