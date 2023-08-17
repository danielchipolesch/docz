package br.com.docz.Service;

import br.com.docz.Model.Entity.AssuntoBasico;
import br.com.docz.Model.Repository.AssuntoBasicoRepository;
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
	public AssuntoBasico criar(AssuntoBasico assuntoBasico){
		return assuntoBasicoRepository.save(assuntoBasico);
	}
	
	@Transactional
	public List<AssuntoBasico> listarTodos(AssuntoBasico assuntoBasico){
		return assuntoBasicoRepository.findAll();
	}
	
	@Transactional
	public Optional<AssuntoBasico> listarPorId(Integer id){
		return assuntoBasicoRepository.findById(id);
	}
	
	@Transactional
	public AssuntoBasico atualizar (AssuntoBasico assuntoBasico) {
		return assuntoBasicoRepository.save(assuntoBasico);
	}
	
	@Transactional
	public void deletar (Integer id){
		assuntoBasicoRepository.deleteById(id);
	}

}
