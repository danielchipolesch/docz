package br.com.docz.controller;

import br.com.docz.dto.DocumentoDto;
import br.com.docz.exception.DocumentoException;
import br.com.docz.model.entity.*;
import br.com.docz.service.*;
import jakarta.validation.Valid;
import net.sf.jasperreports.engine.JRException;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.FileNotFoundException;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/documento")
@CrossOrigin(origins = "*")
public class DocumentoController {
	
	@Autowired
	private DocumentoService documentoService;
	
	@Autowired
	private EspecieService especieService;
	
	@Autowired
	private AssuntoBasicoService assuntoBasicoService;
	
	@Autowired
	private AtoAprovacaoService atoAprovacaoService;
	
	@Autowired
	private SumarioService sumarioService;
	
	@Autowired
	private PrefacioService prefacioService;
	
	@Autowired
	private ReferenciaService referenciaService;
	
	@PostMapping()
	public ResponseEntity<Object> criar (@RequestBody @Valid DocumentoDto documentoDto){
		
		Optional<Especie> especie = especieService.listarPorId(documentoDto.especie().getCodigoEspecie());
		if (especie.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Espécie não encontrada");
		}
		
		Optional<AssuntoBasico> assuntoBasico = assuntoBasicoService.listarPorId(documentoDto.assuntoBasico().getCodigoAssuntoBasico());
		if (assuntoBasico.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assunto básico não encontrado");
		}
		
		try {
			var documentoModel = new Documento();
			BeanUtils.copyProperties(documentoDto, documentoModel);
			documentoModel.setEspecie(especie.get());
			documentoModel.setAssuntoBasico(assuntoBasico.get());
			return ResponseEntity.status(HttpStatus.CREATED).body(documentoService.criar(documentoModel));
		} catch (RuntimeException runtimeException){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
		}
	}
	@GetMapping()
	public ResponseEntity<Object> listarTodos(DocumentoDto documentoDto){
		try {
			var documentoModel = new Documento();
			BeanUtils.copyProperties(documentoDto, documentoModel);
			return ResponseEntity.status(HttpStatus.OK).body(documentoService.listarTodos(documentoModel));
		} catch (RuntimeException runtimeException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> listarPorId(@PathVariable(value = "id") Integer id){
		Optional<Documento> documento = documentoService.listarPorId(id);
		return documento.isEmpty() ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(DocumentoException.objectNotFound()) : ResponseEntity.status(HttpStatus.OK).body(documento.get());
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Integer id,
	                                        @RequestBody @Valid DocumentoDto documentoDto){
		
		Optional<Documento> documento = documentoService.listarPorId(id);
		
		if (documento.isPresent()){
			
			try {
				Optional<Especie> especie = especieService.listarPorId(documentoDto.especie().getCodigoEspecie());
				if (especie.isEmpty()){
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Espécie não encontrada");
				}
				
				Optional<AssuntoBasico> assuntoBasico = assuntoBasicoService.listarPorId(documentoDto.assuntoBasico().getCodigoAssuntoBasico());
				if (assuntoBasico.isEmpty()){
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assunto básico não encontrado");
				}
				
				Optional<AtoAprovacao> atoAprovacao = atoAprovacaoService.listarPorId(documentoDto.atoAprovacao().getCodigoAtoAprovacao());
				if (atoAprovacao.isEmpty()){
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ato de aprovação não encontrado");
				}
				
				Optional<Sumario> sumario = sumarioService.listarPorId(documentoDto.sumario().getCodigoSumario());
				if (sumario.isEmpty()){
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sumário não encontrado");
				}
				
				Optional<Prefacio> prefacio = prefacioService.listarPorId(documentoDto.prefacio().getCodigoPrefacio());
				if (prefacio.isEmpty()){
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prefácio não encontrado");
				}
				
				Optional<Referencia> referencia = referenciaService.listarPorId(documentoDto.referencia().getCodigoReferencia());
				if (referencia.isEmpty()){
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Referência não encontrada");
				}
				
				var documentoModel = documento.get();
				BeanUtils.copyProperties(documentoDto, documentoModel);
				
				documentoModel.setEspecie(especie.get());
				documentoModel.setAssuntoBasico(assuntoBasico.get());
				documentoModel.setAtoAprovacao(atoAprovacao.get());
				documentoModel.setSumario(sumario.get());
				documentoModel.setPrefacio(prefacio.get());
				documentoModel.setReferencia(referencia.get());
				return ResponseEntity.status(HttpStatus.OK).body(documentoService.atualizar(documentoModel));
			} catch (Exception e){
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getCause().getCause().getMessage());
			}
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(DocumentoException.parameterNotNull());
		}
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Object> deletar(@PathVariable(value = "id") Integer id){
		Optional<Documento> documento = documentoService.listarPorId(id);
		if (documento.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(DocumentoException.objectNotFound());
		}
		
		try {
			documentoService.deletar(id);
			return ResponseEntity.status(HttpStatus.OK).body("Documento deletado com sucesso!");
		} catch (RuntimeException runtimeException) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(runtimeException.getCause().getCause().getMessage());
		}
	}
	
	@GetMapping("/{id}/pdf")
	public ResponseEntity<byte[]> generatePdf(@PathVariable(value = "id") Integer id) throws FileNotFoundException, JRException {
		
		Optional<Documento> documento = documentoService.listarPorId(id);
//		if (documento.isEmpty()) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(DocumentoException.objectNotFound());
//		}
		
		var documentoPdf = documentoService.gerarPdf(id);


		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_PDF).body(documentoPdf);
	}
}
