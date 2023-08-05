package br.com.docz.service.implementation;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.docz.model.entity.Documento;
import br.com.docz.model.repository.DocumentoRepository;
import br.com.docz.service.DocumentoService;
import jakarta.transaction.Transactional;

@Service
public class DocumentoServiceImpl implements DocumentoService {
	
	@Autowired
	private DocumentoRepository documentoRepository;

	public DocumentoServiceImpl(DocumentoRepository documentoRepository) {
		this.documentoRepository = documentoRepository;
	}

	/**
	 * Método para retornar uma lista de todos os documentos
	 * @return Lista de documentos
	 * */
	@Override
	@Transactional
	public List<Documento> obterTodos(Documento documentoParamFiltro) {
		Example<Documento> example = Example.of(documentoParamFiltro);
		return documentoRepository.findAll(example);
	}

	/** 
	 * Método que retorna um documento localizado pelo seu Id
	 * @param Id
	 * @return Um documento por Id
	 * */
	@Override
	@Transactional
	public Optional<Documento> obterPorId(UUID id) {
		return documentoRepository.findById(id);	
	}

	/**
	 * @param documento
	 * @return 
	 * */
	@Override
	@Transactional
	public Documento salvar(Documento documento) {
		
		// TODO Auto-generated method stub
		return documentoRepository.save(documento);
	}

	/**
	 * Remove documento antigo da lista e adiciona o novo documento.
	 * @param documento que será atualizado.
	 * @return produto após atualizar o documento atualizado.
	 */
	@Override
	@Transactional
	public Documento atualizar(Documento documento) {
		Objects.requireNonNull(documento.getId());
		return documentoRepository.save(documento);
	}

	/**
	 * Método para deletar um documento pelo Id
	 * @param Id do documento a ser deletado
	 */
	
	@Override
	@Transactional
	public void deletar(Documento documento) {
		Objects.requireNonNull(documento.getId());
		documentoRepository.delete(documento);
	}
	
//	@Override
//	public void flush() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public <S extends Documento> S saveAndFlush(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Documento> List<S> saveAllAndFlush(Iterable<S> entities) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void deleteAllInBatch(Iterable<Documento> entities) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAllInBatch() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Documento getOne(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Documento getById(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Documento getReferenceById(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Documento> List<S> findAll(Example<S> example) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Documento> List<S> findAll(Example<S> example, Sort sort) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Documento> List<S> saveAll(Iterable<S> entities) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Documento> findAll() {
//		return documentoRepository.findAll();
//	}
//
//	@Override
//	public List<Documento> findAllById(Iterable<Integer> ids) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Documento> S save(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Optional<Documento> findById(Integer id) {
//		return documentoRepository.findById(id);
////		return Optional.empty();
//	}
//
//	@Override
//	public boolean existsById(Integer id) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public long count() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public void deleteById(Integer id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void delete(Documento entity) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAllById(Iterable<? extends Integer> ids) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAll(Iterable<? extends Documento> entities) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteAll() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public List<Documento> findAll(Sort sort) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Page<Documento> findAll(Pageable pageable) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Documento> Optional<S> findOne(Example<S> example) {
//		// TODO Auto-generated method stub
//		return Optional.empty();
//	}
//
//	@Override
//	public <S extends Documento> Page<S> findAll(Example<S> example, Pageable pageable) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public <S extends Documento> long count(Example<S> example) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public <S extends Documento> boolean exists(Example<S> example) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public <S extends Documento, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
