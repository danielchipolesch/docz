package br.com.docz.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.docz.dto.DocumentoDto;
import br.com.docz.ExceptionHandler.RegraNegocioException;
import br.com.docz.model.entity.Documento;
import br.com.docz.service.DocumentoService;

@RestController
@RequestMapping("/api/v1/documentos")
public class DocumentoController {
	
	DocumentoService service;
	
	public DocumentoController(DocumentoService service) {
		this.service = service;
	}
	
	/**
	 * Método auxiliar para converter ObjetoDTO em uma entidade
	 * @param dto
	 * @return
	 */
	private Documento converter(DocumentoDto dto) {
		Documento documento = new Documento();
		
		//documento.setNomeDocumento(dto.getNomeDocumento());
		//documento.setTipoDocumento(dto.getTipoDocumento());
		//documento.setNumeroTipoDocumento(dto.getNumeroTipoDocumento());
		
		return documento;
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Object> buscar(
			@RequestParam(value="nomeDocumento", required=false) String nomeDocumento,
			@RequestParam(value="tipoDocumento", required=false) String tipoDocumento,
			@RequestParam(value="numeroTipoDocumento", required=false) Integer numeroTipoDocumento
			) {
		Documento documentoFiltro = new Documento();
		//documentoFiltro.setNomeDocumento(nomeDocumento);
		//documentoFiltro.setTipoDocumento(tipoDocumento);
		//documentoFiltro.setNumeroTipoDocumento(numeroTipoDocumento);
		List<Documento> documentos = service.obterTodos(documentoFiltro);
		return ResponseEntity.ok(documentos);
	}

	@PostMapping("/salvar")
	public ResponseEntity<Object> salvar(@RequestBody DocumentoDto dto) {
		
		try {
			Documento entidadeDocumento = converter(dto);
			
			entidadeDocumento = service.salvar(entidadeDocumento);
			return ResponseEntity.ok(entidadeDocumento);
			
		} catch (RegraNegocioException regraNegocioException) {
			return ResponseEntity.badRequest().body(regraNegocioException.getMessage());
		}
		
	}
	

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<? extends Object> atualizar(@PathVariable("id") UUID id, @RequestBody DocumentoDto dto) {
		return service.obterPorId(id).map(entity -> {
			try {
				Documento documento = converter(dto);
				documento.setId(entity.getId());
				service.atualizar(documento);
				return ResponseEntity.ok(documento);
			} catch (RegraNegocioException regraNegocioException) {
				return ResponseEntity.badRequest().body(regraNegocioException.getMessage());
			}
		}).orElseGet(() -> ResponseEntity.badRequest().body("O documento não foi encontrado na base de dados"));
	}
	
	@DeleteMapping("/deletar/{id}")
	public Optional<Object> deletar(@PathVariable("id") Integer id) {
		return service.obterPorId(id).map(entity -> {
			service.deletar(entity);
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		});
	}
}
