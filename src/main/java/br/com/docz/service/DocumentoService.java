package br.com.docz.service;

import br.com.docz.model.entity.Documento;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DocumentoService {
	
	
	public List<Documento> obterTodos(Documento documentoParamFiltro);
	
	public Optional<Documento> obterPorId(UUID id);
	
	public Documento salvar(Documento documento);
	
	public Documento atualizar(Documento documento);
	
	public void deletar(Documento documento);
	
}
