package br.com.docz.service;

import br.com.docz.model.entity.Especie;
import br.com.docz.model.repository.EspecieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EspecieService {
	@Autowired
	private EspecieRepository especieRepository;
	
	@Transactional
	public Especie criar(Especie especieModel){
		return especieRepository.save(especieModel);
	}
	
	@Transactional
	public Page<Especie> listarTodos(Especie especieModel){
		Sort sort = Sort.by("siglaEspecie").ascending();
		Pageable pageable = PageRequest.of(0, 10, sort);
		return especieRepository.findAll(pageable);
	}
	
}
