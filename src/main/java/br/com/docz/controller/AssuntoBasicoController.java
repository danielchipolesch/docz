package br.com.docz.controller;

import br.com.docz.ExceptionHandler.RegraNegocioException;
import br.com.docz.dto.AssuntoBasicoDto;
import br.com.docz.model.entity.AssuntoBasicoModel;
import br.com.docz.service.AssuntoBasicoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/assunto-basico")
@CrossOrigin(origins = "*")
public class AssuntoBasicoController {
	
	@Autowired
	AssuntoBasicoService assuntoBasicoService;
	
	
	@PostMapping()
	public ResponseEntity<Object> criar(@RequestBody @Valid AssuntoBasicoDto assuntoBasicoDto){
		try {
			var assuntoBasicoModel = new AssuntoBasicoModel();
			BeanUtils.copyProperties(assuntoBasicoDto, assuntoBasicoModel);
			return ResponseEntity.status(HttpStatus.CREATED).body(assuntoBasicoService.criar(assuntoBasicoModel));
		} catch (RegraNegocioException regraNegocioException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(regraNegocioException.getMessage());
		}
		
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> listarTodos(AssuntoBasicoDto assuntoBasicoDto){
		try {
			var assuntoBasicoModel = new AssuntoBasicoModel();
			BeanUtils.copyProperties(assuntoBasicoDto, assuntoBasicoModel);
			return ResponseEntity.status(HttpStatus.OK).body(assuntoBasicoService.listarTodos(assuntoBasicoModel));
		} catch (RegraNegocioException regraNegocioException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(regraNegocioException.getMessage());
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> listarPorId(@PathVariable(value = "id") Integer id){
		Optional<AssuntoBasicoModel> assuntoBasico = assuntoBasicoService.listarPorId(id);
		if (assuntoBasico.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assunto básico não existe na base de dados");
		}
		return ResponseEntity.status(HttpStatus.OK).body(assuntoBasico.get());
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Integer id,
											@RequestBody @Valid AssuntoBasicoDto assuntoBasicoDto){
		
		Optional<AssuntoBasicoModel> assuntoBasico = assuntoBasicoService.listarPorId(id);
		
		if (assuntoBasico.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assunto básico não encontrado");
		}
		
		var assuntoBasicoModel = assuntoBasico.get();
		
		try {
			BeanUtils.copyProperties(assuntoBasicoDto, assuntoBasicoModel);
			return ResponseEntity.status(HttpStatus.OK).body(assuntoBasicoService.atualizar(assuntoBasicoModel));
		} catch (RegraNegocioException | NullPointerException | DataIntegrityViolationException error) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		}
		
	}
	
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Object> deletar(@PathVariable(value = "id") Integer id){
		Optional<AssuntoBasicoModel> assuntoBasico = assuntoBasicoService.listarPorId(id);
		if (assuntoBasico.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assunto básico não encontrado");
		}
		assuntoBasicoService.deletar(assuntoBasico.get());
		return ResponseEntity.status(HttpStatus.OK).body("Assunto básico deletado com sucesso!");
	}
	
}
