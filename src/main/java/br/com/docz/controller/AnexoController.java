package br.com.docz.controller;

import br.com.docz.dto.AnexoDto;
import br.com.docz.exception.AnexoException;
import br.com.docz.exception.DocumentoException;
import br.com.docz.model.entity.Anexo;
import br.com.docz.model.entity.Documento;
import br.com.docz.service.AnexoService;
import br.com.docz.service.DocumentoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/anexo")
@CrossOrigin(origins = "*")
public class AnexoController {
	
	@Autowired
	AnexoService anexoService;
	
	@Autowired
	DocumentoService documentoService;
	
	@PostMapping()
	public ResponseEntity<Object> criar (@RequestBody @Valid AnexoDto anexoDto){
		
		var id = anexoDto.documento().getCodigoDocumento();
		Documento documento = documentoService.listarPorId(id).get();
		
		if (documento != null){
		
			try {
				var anexoModel = new Anexo();
				BeanUtils.copyProperties(anexoDto, anexoModel);
				anexoModel.setDocumento(documento);
				return ResponseEntity.status(HttpStatus.CREATED).body(anexoService.criar(anexoModel));
			
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
			}
		
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(DocumentoException.objectNotFound());
		}
	}
	
	@GetMapping()
	public ResponseEntity<Object> listarTodos(AnexoDto anexoDto){
		try {
			var anexoModel = new Anexo();
			BeanUtils.copyProperties(anexoDto, anexoModel);
			return ResponseEntity.status(HttpStatus.OK).body(anexoService.listarTodos(anexoModel));
		} catch (RuntimeException runtimeException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> listarPorId(@PathVariable(value = "id") Integer id){
		Optional<Anexo> anexo = anexoService.listarPorId(id);
		return anexo.isEmpty() ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(AnexoException.objectNotFound()) : ResponseEntity.status(HttpStatus.OK).body(anexo.get());
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Integer id,
	                                        @RequestBody @Valid AnexoDto anexoDto){
		
		Optional<Anexo> anexo = anexoService.listarPorId(id);
		
		if (anexo.isEmpty()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(AnexoException.parameterNotNull());
		}
		
		var idDocumento = anexoDto.documento().getCodigoDocumento();
		Optional<Documento> documento = documentoService.listarPorId(idDocumento);
		if (documento.isPresent()) {
			
			try {
				var anexoModel = anexo.get();
				BeanUtils.copyProperties(anexoDto, anexoModel);
				anexoModel.setDocumento(documento.get());
				return ResponseEntity.status(HttpStatus.OK).body(anexoService.atualizar(anexoModel));
			} catch (RuntimeException runtimeException) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
			}
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(DocumentoException.objectNotFound());
		}
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Object> deletar(@PathVariable(value = "id") Integer id){
		Optional<Anexo> anexo = anexoService.listarPorId(id);
		if (anexo.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(AnexoException.objectNotFound());
		}
		
		try {
			anexoService.deletar(id);
			return ResponseEntity.status(HttpStatus.OK).body("Anexo deletado com sucesso!");
		} catch (RuntimeException runtimeException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
		}
	}
}
