package br.com.docz.controller;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.docz.dto.SumarioDto;
import br.com.docz.exception.SumarioException;
import br.com.docz.service.SumarioService;
import br.com.docz.model.entity.Sumario;


@RestController
@RequestMapping("/api/v1/sumario")
@CrossOrigin(origins = "*")
public class SumarioController {
	
	@Autowired
	private SumarioService sumarioService;
	
	private String sumarioConst = "Sumário"; 
	
//	@PostMapping()
//	public ResponseEntity<Object> criar(@RequestBody SumarioDto sumarioDto){
//		try {
//			var sumarioModel = new Sumario();
//			BeanUtils.copyProperties(sumarioDto, sumarioModel);
//			return ResponseEntity.status(HttpStatus.CREATED).body(sumarioService.criar());
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getCause().getCause().getMessage());
//		}
//	}
	
	@GetMapping()
	public ResponseEntity<Object> listarTodos(SumarioDto sumarioDto){
		try {
			var sumarioModel = new Sumario();
			BeanUtils.copyProperties(sumarioDto, sumarioModel);
			return ResponseEntity.status(HttpStatus.OK).body(sumarioService.listarTodos(sumarioModel));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getCause().getCause().getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> listarPorId(@PathVariable(value="id") Integer id){
		Optional<Sumario> sumario = sumarioService.listarPorId(id);
		return sumario.isEmpty() ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(SumarioException.objectNotFound(sumarioConst)) : ResponseEntity.status(HttpStatus.OK).body(sumario.get());
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Object> atualizar(@PathVariable(value="id") Integer id,
											@RequestBody SumarioDto sumarioDto){
		Optional<Sumario> sumario = sumarioService.listarPorId(id);
		if (sumario.isEmpty()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(SumarioException.parameterNotNull());
		}
		try {
			var sumarioModel = sumario.get();
			BeanUtils.copyProperties(sumarioDto, sumarioModel);
			return ResponseEntity.status(HttpStatus.OK).body(sumarioService.atualizar(sumarioModel));
		} catch (Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getCause().getCause().getMessage());
		}
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Object> deletar(@PathVariable(value="id") Integer id){
		Optional<Sumario> sumario = sumarioService.listarPorId(id);
		if (sumario.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(SumarioException.objectNotFound(sumarioConst));
		}
		
		try {
			sumarioService.deletar(id);
			return ResponseEntity.status(HttpStatus.OK).body("Sumário deletado com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getCause().getCause().getMessage());
		}
	}
}
