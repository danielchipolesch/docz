package br.com.docz.service;

import br.com.docz.model.entity.Documento;
import br.com.docz.model.repository.DocumentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService {
	
	@Autowired
	private DocumentoRepository documentoRepository;

	@Transactional
	public Documento criar(Documento documento) {
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
}
