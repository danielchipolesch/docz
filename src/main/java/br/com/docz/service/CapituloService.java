package br.com.docz.service;

import br.com.docz.model.entity.Capitulo;
import br.com.docz.model.entity.Documento;
import br.com.docz.model.repository.CapituloRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CapituloService {
	
	@Autowired
	private CapituloRepository capituloRepository;
	@Autowired
	DocumentoService documentoService;
	

	@Transactional
	public Capitulo criar(Capitulo capitulo) {
		var id = capitulo.getDocumento().getCodigoDocumento();
		Optional<Documento> documento = documentoService.listarPorId(id);
		capitulo.setDocumento(documento.get());
		return capituloRepository.save(capitulo);
	}
	
	@Transactional
	public List<Capitulo> listarTodos(Capitulo capitulo){
		return capituloRepository.findAll();
	}
	
	@Transactional
	public Optional<Capitulo> listarPorId(Integer id) {
		return capituloRepository.findById(id);
	}
	
	@Transactional
	public Capitulo atualizar(Capitulo capitulo) {
		var id = capitulo.getDocumento().getCodigoDocumento();
		Optional<Documento> documento = documentoService.listarPorId(id);
		capitulo.setDocumento(documento.get());
		return capituloRepository.save(capitulo);
	}
	
	@Transactional
	public void deletar(Integer id) {
		capituloRepository.deleteById(id);
	}
}
