package br.com.docz.service;

import br.com.docz.model.entity.Capitulo;
import br.com.docz.model.entity.Documento;
import br.com.docz.model.repository.CapituloRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CapituloService {
	
	@Autowired
	private CapituloRepository capituloRepository;
	
	@Autowired
	private DocumentoService documentoService;
	

	@Transactional
	public Capitulo criar(Capitulo capitulo) {
		var idDocumento = capitulo.getDocumento().getCodigoDocumento();
		var documento = documentoService.listarPorId(idDocumento);
		var capitulosPorDocumento = documento.get().getCapitulos();
		var numeroOrdemCapituloPorDocumento = capitulosPorDocumento.size();
		
		capitulo.setNumeroOrdemCapitulo(numeroOrdemCapituloPorDocumento+1);
		return capituloRepository.save(capitulo);
	}
	
	@Transactional
	public List<Capitulo> listarTodos(Capitulo capitulo){
		return capituloRepository.findAll();
	}
	
	@Transactional
	public Optional<Capitulo> listarPorId(Integer id) {
		return capituloRepository.findById(id);
	}
	
	@Transactional
	public Capitulo atualizar(Capitulo capitulo) {
		// TODO: função para reorganizar capítulos.
		return capituloRepository.save(capitulo);
	}
	
	@Transactional
	public void deletar(Integer id) {
		capituloRepository.deleteById(id);
	}
}
