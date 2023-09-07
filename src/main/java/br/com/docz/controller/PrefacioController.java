package br.com.docz.controller;

import br.com.docz.dto.PrefacioDto;
import br.com.docz.exception.PrefacioException;
import br.com.docz.model.entity.Prefacio;
import br.com.docz.service.PrefacioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1/prefacio")
@CrossOrigin(origins = "*")
public class PrefacioController {
	
	@Autowired
	private PrefacioService prefacioService;
	
	private String prefacioConst = "Prefácio";
	
//	@PostMapping()
//	public ResponseEntity<Object> criar(@RequestBody PrefacioDto prefacioDto){
//		try {
//			var prefacioModel = new Prefacio();
//			BeanUtils.copyProperties(prefacioDto, prefacioModel);
//			return ResponseEntity.status(HttpStatus.CREATED).body(prefacioService.criar());
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getCause().getCause().getMessage());
//		}
//	}
	
	@GetMapping()
	public ResponseEntity<Object> listarTodos(PrefacioDto prefacioDto){
		try {
			var prefacioModel = new Prefacio();
			BeanUtils.copyProperties(prefacioDto, prefacioModel);
			return ResponseEntity.status(HttpStatus.OK).body(prefacioService.listarTodos(prefacioModel));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getCause().getCause().getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> listarPorId(@PathVariable(value="id") Integer id){
		Optional<Prefacio> prefacio = prefacioService.listarPorId(id);
		return prefacio.isEmpty() ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(PrefacioException.objectNotFound(prefacioConst)) : ResponseEntity.status(HttpStatus.OK).body(prefacio.get());
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Object> atualizar(@PathVariable(value="id") Integer id,
											@RequestBody PrefacioDto prefacioDto){
		Optional<Prefacio> prefacio = prefacioService.listarPorId(id);
		if (prefacio.isEmpty()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(PrefacioException.parameterNotNull());
		}
		try {
			var prefacioModel = prefacio.get();
			BeanUtils.copyProperties(prefacioDto, prefacioModel);
			return ResponseEntity.status(HttpStatus.OK).body(prefacioService.atualizar(prefacioModel));
		} catch (Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getCause().getCause().getMessage());
		}
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Object> deletar(@PathVariable(value="id") Integer id){
		Optional<Prefacio> prefacio = prefacioService.listarPorId(id);
		if (prefacio.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(PrefacioException.objectNotFound(prefacioConst));
		}
		
		try {
			prefacioService.deletar(id);
			return ResponseEntity.status(HttpStatus.OK).body("Prefácio deletado com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getCause().getCause().getMessage());
		}
	}
}
