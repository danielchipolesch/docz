package br.com.docz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.docz.model.entity.AtoAprovacao;
import br.com.docz.model.repository.AtoAprovacaoRepository;
import jakarta.transaction.Transactional;

@Service
public class AtoAprovacaoService {
	
	@Autowired
	private AtoAprovacaoRepository atoAprovacaoRepository;

	@Transactional
	public AtoAprovacao criar(AtoAprovacao atoAprovacao) {
		return atoAprovacaoRepository.save(atoAprovacao);
	}
	
	@Transactional
	public List<AtoAprovacao> listarTodos(AtoAprovacao atoAprovacao){
		return atoAprovacaoRepository.findAll();
	}
	
	@Transactional
	public Optional<AtoAprovacao> listarPorId(Integer id) {
		return atoAprovacaoRepository.findById(id);
	}
	
	@Transactional
	public AtoAprovacao atualizar(AtoAprovacao atoAprovacao) {
		return atoAprovacaoRepository.save(atoAprovacao);
	}
	
	@Transactional
	public void deletar(Integer id) {
		atoAprovacaoRepository.deleteById(id);
	}
}
