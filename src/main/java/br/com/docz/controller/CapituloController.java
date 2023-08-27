package br.com.docz.controller;

import br.com.docz.dto.CapituloDto;
import br.com.docz.exception.CapituloException;
import br.com.docz.exception.DocumentoException;
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
	
	@Autowired
	DocumentoService documentoService;
	
	@PostMapping()
	public ResponseEntity<Object> criar (@RequestBody @Valid CapituloDto capituloDto){
		
		var id = capituloDto.documento().getCodigoDocumento();
		Optional<Documento> documento = documentoService.listarPorId(id);
		
		if (documento.isPresent()){
		
			try {
				var capituloModel = new Capitulo();
				BeanUtils.copyProperties(capituloDto, capituloModel);
				capituloModel.setDocumento(documento.get());
				return ResponseEntity.status(HttpStatus.CREATED).body(capituloService.criar(capituloModel));
			
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
			}
		
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(DocumentoException.objectNotFound());
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
		
		var idDocumento = capituloDto.documento().getCodigoDocumento();
		Optional<Documento> documento = documentoService.listarPorId(idDocumento);
		if (documento.isPresent()) {
			
			try {
				var capituloModel = capitulo.get();
				BeanUtils.copyProperties(capituloDto, capituloModel);
				capituloModel.setDocumento(documento.get());
				return ResponseEntity.status(HttpStatus.OK).body(capituloService.atualizar(capituloModel));
			} catch (RuntimeException runtimeException) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(DocumentoException.objectNotFound());
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
