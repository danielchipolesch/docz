package br.com.docz.controller;

import br.com.docz.ExceptionHandler.RegraNegocioException;
import br.com.docz.dto.AssuntoBasicoDto;
import br.com.docz.model.entity.AssuntoBasico;
import br.com.docz.service.AssuntoBasicoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assunto-basico")
@CrossOrigin(origins = "*")
public class AssuntoBasicoController {
	
	AssuntoBasicoService assuntoBasicoService;
	RegraNegocioException regraNegocioException;
	
	public AssuntoBasicoController(AssuntoBasicoService assuntoBasicoService){
		this.assuntoBasicoService=assuntoBasicoService;
	}
	
	@PostMapping()
	public ResponseEntity<Object> criar(@RequestBody @Valid AssuntoBasicoDto assuntoBasicoDto){
		try {
			AssuntoBasico assuntoBasicoModel = new AssuntoBasico();
			BeanUtils.copyProperties(assuntoBasicoDto, assuntoBasicoModel);
			return ResponseEntity.status(HttpStatus.CREATED).body(assuntoBasicoService.criar(assuntoBasicoModel));
		} catch (RegraNegocioException regraNegocioException) {
			return ResponseEntity.badRequest().body(regraNegocioException.getMessage());
		}
		
	}
	
	@GetMapping()
	public ResponseEntity<List<Object>> listarTodos(AssuntoBasicoDto assuntoBasicoDto){
		try {
			AssuntoBasico assuntoBasicoModel = new AssuntoBasico();
			BeanUtils.copyProperties(assuntoBasicoDto, assuntoBasicoModel);
			return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonList(assuntoBasicoService.listarTodos(assuntoBasicoModel)));
		} catch (RegraNegocioException regraNegocioException) {
			return ResponseEntity.badRequest().body(Collections.singletonList(regraNegocioException.getMessage()));
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> listarPorId(@PathVariable(value = "id") Long id){
		Optional<AssuntoBasico> assuntoBasico = assuntoBasicoService.listarPorId(id);
		if (assuntoBasico.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(regraNegocioException.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(assuntoBasico.get());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> atualizar(@PathVariable(value="id") Long id,
	                                        @RequestBody @Valid AssuntoBasicoDto assuntoBasicoDto){
		Optional<AssuntoBasico> assuntoBasico = assuntoBasicoService.listarPorId(id);
		if (assuntoBasico.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(regraNegocioException.getMessage());
		}
		var assuntoBasicoModel = new AssuntoBasico();
		BeanUtils.copyProperties(assuntoBasicoDto, assuntoBasicoModel);
		return ResponseEntity.status(HttpStatus.OK).body(assuntoBasicoService.atualizar(assuntoBasicoModel));
	}
	
	@DeleteMapping()
	public ResponseEntity<Object> deletar(@PathVariable(value = "id") Long id){
		Optional<AssuntoBasico> assuntoBasico = assuntoBasicoService.listarPorId(id);
		if (assuntoBasico.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assunto básico não encontrado");
		}
		assuntoBasicoService.deletar(assuntoBasico.get());
		return ResponseEntity.status(HttpStatus.OK).body("Assunto básico deletado com sucesso!");
	}

}
