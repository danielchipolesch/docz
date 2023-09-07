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
	public AtoAprovacao criar() {
		AtoAprovacao atoAprovacao = new AtoAprovacao();
		atoAprovacao.setNumeroPortaria("Exemplo: Portaria n° 123/PP5-1, de 23 de agosto de 2023");
		atoAprovacao.setTextoEmenta("Aprova a edição da ICA XYZ-W [...]");
		atoAprovacao.setTextoPortaria("O Diretor de Administração da Aeronáutica, no uso das atribuições que lhe conferem o art.5°, do [...]");
		atoAprovacao.setNomeAutoridade("Maj Brig Int FULANO DE TAL");
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
