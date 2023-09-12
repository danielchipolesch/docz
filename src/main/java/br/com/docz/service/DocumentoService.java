package br.com.docz.service;


import br.com.docz.model.entity.Documento;
import br.com.docz.helper.StatusDocumento;
import br.com.docz.model.repository.AssuntoBasicoRepository;
import br.com.docz.model.repository.DocumentoRepository;
import jakarta.transaction.Transactional;
import net.sf.jasperreports.engine.*;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService {
	
	@Autowired
	private DocumentoRepository documentoRepository;
	
	@Autowired
	private AtoAprovacaoService atoAprovacaoService;
	
	@Autowired
	private SumarioService sumarioService;
	
	@Autowired
	private PrefacioService prefacioService;
	
	@Autowired
	private ReferenciaService referenciaService;
	
	@Autowired
	private AssuntoBasicoRepository assuntoBasicoRepository;

	@Transactional
	public Documento criar(Documento documento) {
		documento.setAtoAprovacao(atoAprovacaoService.criar());
		documento.setSumario(sumarioService.criar());
		documento.setPrefacio(prefacioService.criar());
		documento.setReferencia(referenciaService.criar());
		documento.setStatusDocumento(StatusDocumento.RASCUNHO);
		return documentoRepository.save(documento);
	}
	
	@Transactional
	public List<Documento> listarTodos(Documento documento){
		return documentoRepository.findAll();
	}
	
	@Transactional
	public Optional<Documento> listarPorId(Integer id) {
		return documentoRepository.findById(id);
	}
	
	@Transactional
	public Documento atualizar(Documento documento) {
		return documentoRepository.save(documento);
	}
	
	@Transactional
	public void deletar(Integer id) {
		documentoRepository.deleteById(id);
	}
	
	public byte[] gerarPdf(Integer id) throws FileNotFoundException, JRException {
		

		Documento documento = documentoRepository.findById(id).get();
		List<Documento> documentoList = new ArrayList<>();
		documentoList.add(documento);
	
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(documentoList);
		
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("nomeEpigrafeDocumento", documento.getNomeEpigrafeDocumento());
		parameters.put("nomeOrgao", documento.getNomeOrgao());
		String path = "src/main/resources/templates/";
		
		JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream(path+"/Documento.jrxml"));		
//		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JRBeanCollectionDataSource(documentoList));
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
		
		return JasperExportManager.exportReportToPdf(jasperPrint);
	}
}
