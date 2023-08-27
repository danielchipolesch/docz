package br.com.docz.service;

import br.com.docz.model.entity.Anexo;
import br.com.docz.model.repository.AnexoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnexoService {
	
	@Autowired
	private AnexoRepository anexoRepository;

	@Transactional
	public Anexo criar(Anexo anexo) {
		return anexoRepository.save(anexo);
	}
	
	@Transactional
	public List<Anexo> listarTodos(Anexo anexo){
		return anexoRepository.findAll();
	}
	
	@Transactional
	public Optional<Anexo> listarPorId(Integer id) {
		return anexoRepository.findById(id);
	}
	
	@Transactional
	public Anexo atualizar(Anexo anexo) {
		return anexoRepository.save(anexo);
	}
	
	@Transactional
	public void deletar(Integer id) {
		anexoRepository.deleteById(id);
	}
}
