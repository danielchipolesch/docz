package br.com.docz.service;

import br.com.docz.model.entity.AssuntoBasico;
import br.com.docz.model.repository.AssuntoBasicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssuntoBasicoService {

	@Autowired
	private AssuntoBasicoRepository assuntoBasicoRepository;
	
	public AssuntoBasicoService(AssuntoBasicoRepository assuntoBasicoRepository){
		this.assuntoBasicoRepository=assuntoBasicoRepository;
	}
	
	public AssuntoBasico criar(AssuntoBasico assuntoBasico){
		return assuntoBasicoRepository.save(assuntoBasico);
	}
	
	@Transactional
	public List<AssuntoBasico> listarTodos(){
		return assuntoBasicoRepository.findAll();
	}
	
	@Transactional
	public Optional<AssuntoBasico> listarPorId(Long id){
		return assuntoBasicoRepository.findById(id);
	}
	
	@Transactional
	public AssuntoBasico atualizar (AssuntoBasico assuntoBasico) {
		return assuntoBasicoRepository.save(assuntoBasico);
	}
	
	@Transactional
	public void deletar (AssuntoBasico assuntoBasico){
		assuntoBasicoRepository.delete(assuntoBasico);
	}

}
