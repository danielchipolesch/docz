package br.com.docz.service;

import br.com.docz.model.entity.Referencia;
import br.com.docz.model.repository.ReferenciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReferenciaService {
	
	@Autowired
	private ReferenciaRepository referenciaRepository;

	@Transactional
	public Referencia criar() {
		Referencia referencia = new Referencia();
		referencia.setTextoReferencia("Este é um exemplo de texto para as Referências. Altere este texto.");
		return referenciaRepository.save(referencia);
	}
	
	@Transactional
	public List<Referencia> listarTodos(Referencia referencia){
		return referenciaRepository.findAll();
	}
	
	@Transactional
	public Optional<Referencia> listarPorId(Integer id) {
		return referenciaRepository.findById(id);
	}
	
	@Transactional
	public Referencia atualizar(Referencia referencia) {
		return referenciaRepository.save(referencia);
	}
	
	@Transactional
	public void deletar(Integer id) {
		referenciaRepository.deleteById(id);
	}
}
