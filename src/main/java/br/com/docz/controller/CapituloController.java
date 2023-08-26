package br.com.docz.controller;

import br.com.docz.dto.CapituloDto;
import br.com.docz.exception.CapituloException;
import br.com.docz.model.entity.Capitulo;
import br.com.docz.model.entity.Documento;
import br.com.docz.service.CapituloService;
import br.com.docz.service.DocumentoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/capitulo")
@CrossOrigin(origins = "*")
public class CapituloController {
	
	@Autowired
	CapituloService capituloService;
	
	@PostMapping()
	public ResponseEntity<Object> criar (@RequestBody @Valid CapituloDto capituloDto){
		try {
			var capituloModel = new Capitulo();
			BeanUtils.copyProperties(capituloDto, capituloModel);
			return ResponseEntity.status(HttpStatus.CREATED).body(capituloService.criar(capituloModel));
		} catch (RuntimeException runtimeException){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
		}
	}
	@GetMapping()
	public ResponseEntity<Object> listarTodos(CapituloDto capituloDto){
		try {
			var capituloModel = new Capitulo();
			BeanUtils.copyProperties(capituloDto, capituloModel);
			return ResponseEntity.status(HttpStatus.OK).body(capituloService.listarTodos(capituloModel));
		} catch (RuntimeException runtimeException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> listarPorId(@PathVariable(value = "id") Integer id){
		Optional<Capitulo> capitulo = capituloService.listarPorId(id);
		return capitulo.isEmpty() ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(CapituloException.objectNotFound()) : ResponseEntity.status(HttpStatus.OK).body(capitulo.get());
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Integer id,
	                                        @RequestBody @Valid CapituloDto capituloDto){
		
		Optional<Capitulo> capitulo = capituloService.listarPorId(id);
		
		if (capitulo.isEmpty()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(CapituloException.parameterNotNull());
		}
		try {
			var capituloModel = capitulo.get();
			BeanUtils.copyProperties(capituloDto, capituloModel);
			return ResponseEntity.status(HttpStatus.OK).body(capituloService.atualizar(capituloModel));
		} catch (RuntimeException runtimeException){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
		}
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Object> deletar(@PathVariable(value = "id") Integer id){
		Optional<Capitulo> capitulo = capituloService.listarPorId(id);
		if (capitulo.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(CapituloException.objectNotFound());
		}
		
		try {
			capituloService.deletar(id);
			return ResponseEntity.status(HttpStatus.OK).body("Capítulo deletado com sucesso!");
		} catch (RuntimeException runtimeException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
		}
	}
}
