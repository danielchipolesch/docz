package br.com.docz.service;

import br.com.docz.model.entity.AtoAprovacao;
import br.com.docz.model.entity.Documento;
import br.com.docz.helper.StatusDocumento;
import br.com.docz.model.repository.DocumentoRepository;
import jakarta.transaction.Transactional;
import net.sf.jasperreports.engine.JRException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
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
	
	public ArrayList<Optional<Documento>> gerarPdf(Integer id) throws FileNotFoundException, JRException {
		
		Optional<Documento> documento = documentoRepository.findById(id);
		
		ArrayList<Optional<Documento>> listaDocumento = new ArrayList<>();
		listaDocumento.add(documento);
//		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listaDocumento);
//		JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/java/br/com/docz/report/Documento.jrxml"));
//		HashMap<String, Object> map = new HashMap<>();
//		JasperPrint report = JasperFillManager.fillReport(compileReport, map, beanCollectionDataSource);
//		//JasperPrint report = JasperExportManager.exportReportToPdfFile(beanCollectionDataSource, "documento.pdf");
//		byte[] data = JasperExportManager.exportReportToPdf(report);
		
		return listaDocumento;
	}
}
