package br.com.docz.service;

import br.com.docz.model.entity.Sumario;
import br.com.docz.model.repository.SumarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SumarioService {
	
	@Autowired
	private SumarioRepository sumarioRepository;

	@Transactional
	public Sumario criar(Sumario sumario) {
		return sumarioRepository.save(sumario);
	}
	
	@Transactional
	public List<Sumario> listarTodos(Sumario sumario){
		return sumarioRepository.findAll();
	}
	
	@Transactional
	public Optional<Sumario> listarPorId(Integer id) {
		return sumarioRepository.findById(id);
	}
	
	@Transactional
	public Sumario atualizar(Sumario sumario) {
		return sumarioRepository.save(sumario);
	}
	
	@Transactional
	public void deletar(Integer id) {
		sumarioRepository.deleteById(id);
	}
}
