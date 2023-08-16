package br.com.docz.controller;

import br.com.docz.ExceptionHandler.RegraNegocioException;
import br.com.docz.dto.EspecieDto;
import br.com.docz.model.entity.Especie;
import br.com.docz.service.EspecieService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/especie")
@CrossOrigin(origins = "*")
public class EspecieController {
	@Autowired
	EspecieService especieService;
	
	@PostMapping()
	public ResponseEntity<Object> criar (@RequestBody @Valid EspecieDto especieDto){
		try {
			var especieModel = new Especie();
			BeanUtils.copyProperties(especieDto, especieModel);
			return ResponseEntity.status(HttpStatus.CREATED).body(especieService.criar(especieModel));
		} catch (RegraNegocioException regraNegocioException){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(regraNegocioException.getMessage());
		}
	}
	@GetMapping()
	public ResponseEntity<Object> listarTodos(EspecieDto especieDto){
		try {
			var especieModel = new Especie();
			BeanUtils.copyProperties(especieDto, especieModel);
			return ResponseEntity.status(HttpStatus.OK).body(especieService.listarTodos(especieModel));
		} catch (RegraNegocioException regraNegocioException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(regraNegocioException.getMessage());
		}
	}
}
