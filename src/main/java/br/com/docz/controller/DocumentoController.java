package br.com.docz.controller;

import br.com.docz.dto.DocumentoDto;
import br.com.docz.exception.DocumentoException;
import br.com.docz.model.entity.Documento;
import br.com.docz.model.entity.Especie;
import br.com.docz.service.DocumentoService;
import br.com.docz.service.EspecieService;
import jakarta.validation.Valid;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSourceProvider;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/documento")
@CrossOrigin(origins = "*")
public class DocumentoController {
	
	@Autowired
	DocumentoService documentoService;
	
	@Autowired
	EspecieService especieService;
	
	@PostMapping()
	public ResponseEntity<Object> criar (@RequestBody @Valid DocumentoDto documentoDto){
		try {
			var documentoModel = new Documento();
			BeanUtils.copyProperties(documentoDto, documentoModel);
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
		
//		var idEspecie = documentoDto.especie().getCodigoEspecie();
//		Optional<Especie> especie = especieService.listarPorId(idEspecie);
		
		Optional<Documento> documento = documentoService.listarPorId(id);
		
		if (documento.isEmpty()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(DocumentoException.parameterNotNull());
		}
		try {
			var documentoModel = documento.get();
			BeanUtils.copyProperties(documentoDto, documentoModel);
			/* TODO
			*  */
			//documentoModel.setEspecie(especie.get());
			return ResponseEntity.status(HttpStatus.OK).body(documentoService.atualizar(documentoModel));
		} catch (Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getCause().getCause().getMessage());
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
	public ResponseEntity<Object> generatePdf(@PathVariable(value = "id") Integer id) throws FileNotFoundException, JRException {
		
		Optional<Documento> documento = documentoService.listarPorId(id);
		if (documento.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(DocumentoException.objectNotFound());
		}
		
		var documentoPdf = documentoService.gerarPdf(id);

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_PDF).body(documentoPdf);
	}
}
