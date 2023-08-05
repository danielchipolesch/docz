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

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assunto-basico")
public class AssuntoBasicoController {
	
	private AssuntoBasicoService assuntoBasicoService;
	private RegraNegocioException regraNegocioException;
	
	@PostMapping()
	public ResponseEntity<AssuntoBasico> criar(@RequestBody @Valid AssuntoBasicoDto assuntoBasicoDto){
		var assuntoBasicoModel = new AssuntoBasico();
		BeanUtils.copyProperties(assuntoBasicoDto, assuntoBasicoModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(assuntoBasicoService.criar(assuntoBasicoModel));
	}
	
	@GetMapping()
	public ResponseEntity<List<AssuntoBasico>> listarTodos(){
		return ResponseEntity.status(HttpStatus.OK).body(assuntoBasicoService.listarTodos());
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
