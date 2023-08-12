package br.com.docz.service;

import br.com.docz.model.entity.AssuntoBasicoModel;
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
	
	@Transactional
	public AssuntoBasicoModel criar(AssuntoBasicoModel assuntoBasico){
		return assuntoBasicoRepository.save(assuntoBasico);
	}
	
	@Transactional
	public List<AssuntoBasicoModel> listarTodos(AssuntoBasicoModel assuntoBasico){
		return assuntoBasicoRepository.findAll();
	}
	
	@Transactional
	public Optional<AssuntoBasicoModel> listarPorId(Integer id){
		return assuntoBasicoRepository.findById(id);
	}
	
	@Transactional
	public AssuntoBasicoModel atualizar (AssuntoBasicoModel assuntoBasico) {
		
		return assuntoBasicoRepository.save(assuntoBasico);
	}
	
	@Transactional
	public void deletar (AssuntoBasicoModel assuntoBasico){
		assuntoBasicoRepository.delete(assuntoBasico);
	}

}
