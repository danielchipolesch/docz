package br.com.docz.Service;

import br.com.docz.Model.Entity.AssuntoBasico;
import br.com.docz.Model.Entity.Especie;
import br.com.docz.Model.Repository.EspecieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EspecieService {
	@Autowired
	private EspecieRepository especieRepository;
	
	@Transactional
	public Especie criar(Especie especie){
		return especieRepository.save(especie);
	}
	
	@Transactional
	public Page<Especie> listarTodos(Especie especieModel){
		Sort sort = Sort.by("siglaEspecie").ascending();
		Pageable pageable = PageRequest.of(0, 10, sort);
		return especieRepository.findAll(pageable);
	}
	
	@Transactional
	public Optional<Especie> listarPorId(Integer id){
		return especieRepository.findById(id);
	}
	
	@Transactional
	public Especie atualizar (Especie especie) {
		return especieRepository.save(especie);
	}
	
	@Transactional
	public void deletar (Integer id){
		especieRepository.deleteById(id);
	}
}
