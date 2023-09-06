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

import br.com.docz.dto.AtoAprovacaoDto;
import br.com.docz.exception.AtoAprovacaoException;
import br.com.docz.service.AtoAprovacaoService;
import br.com.docz.model.entity.AtoAprovacao;


@RestController
@RequestMapping("/api/v1/ato-aprovacao")
@CrossOrigin(origins = "*")
public class AtoAprovacaoController {
	
	@Autowired
	AtoAprovacaoService atoAprovacaoService;
	
	private String atoAprovacaoConst = "Ato de aprovacão"; 
	
	@PostMapping()
	public ResponseEntity<Object> criar(@RequestBody AtoAprovacaoDto atoAprovacaoDto){
		try {
			var atoAprovacaoModel = new AtoAprovacao();
			BeanUtils.copyProperties(atoAprovacaoDto, atoAprovacaoModel);
			return ResponseEntity.status(HttpStatus.CREATED).body(atoAprovacaoService.criar(atoAprovacaoModel));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getCause().getCause().getMessage());
		}
	}
	
	@GetMapping()
	public ResponseEntity<Object> listarTodos(AtoAprovacaoDto atoAprovacaoDto){
		try {
			var atoAprovacaoModel = new AtoAprovacao();
			BeanUtils.copyProperties(atoAprovacaoDto, atoAprovacaoModel);
			return ResponseEntity.status(HttpStatus.OK).body(atoAprovacaoService.listarTodos(atoAprovacaoModel));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getCause().getCause().getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> listarPorId(@PathVariable(value="id") Integer id){
		Optional<AtoAprovacao> atoAprovacao = atoAprovacaoService.listarPorId(id);
		return atoAprovacao.isEmpty() ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(AtoAprovacaoException.objectNotFound(atoAprovacaoConst)) : ResponseEntity.status(HttpStatus.OK).body(atoAprovacao.get());
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Object> atualizar(@PathVariable(value="id") Integer id,
											@RequestBody AtoAprovacaoDto atoAprovacaoDto){
		Optional<AtoAprovacao> atoAprovacao = atoAprovacaoService.listarPorId(id);
		if (atoAprovacao.isEmpty()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(AtoAprovacaoException.parameterNotNull());
		}
		try {
			var atoAprovacaoModel = atoAprovacao.get();
			BeanUtils.copyProperties(atoAprovacaoDto, atoAprovacaoModel);
			return ResponseEntity.status(HttpStatus.OK).body(atoAprovacaoService.atualizar(atoAprovacaoModel));
		} catch (Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getCause().getCause().getMessage());
		}
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Object> deletar(@PathVariable(value="id") Integer id){
		Optional<AtoAprovacao> atoAprovacao = atoAprovacaoService.listarPorId(id);
		if (atoAprovacao.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(AtoAprovacaoException.objectNotFound(atoAprovacaoConst));
		}
		
		try {
			atoAprovacaoService.deletar(id);
			return ResponseEntity.status(HttpStatus.OK).body("Ato de aprovação deletado com sucesso!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getCause().getCause().getMessage());
		}
	}
}
