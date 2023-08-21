package br.com.docz.service;

import br.com.docz.model.entity.Prefacio;
import br.com.docz.model.repository.PrefacioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrefacioService {
	
	@Autowired
	private PrefacioRepository prefacioRepository;

	@Transactional
	public Prefacio criar(Prefacio prefacio) {
		return prefacioRepository.save(prefacio);
	}
	
	@Transactional
	public List<Prefacio> listarTodos(Prefacio prefacio){
		return prefacioRepository.findAll();
	}
	
	@Transactional
	public Optional<Prefacio> listarPorId(Integer id) {
		return prefacioRepository.findById(id);
	}
	
	@Transactional
	public Prefacio atualizar(Prefacio prefacio) {
		return prefacioRepository.save(prefacio);
	}
	
	@Transactional
	public void deletar(Integer id) {
		prefacioRepository.deleteById(id);
	}
}
