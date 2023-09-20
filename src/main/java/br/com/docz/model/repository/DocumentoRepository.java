package br.com.docz.model.repository;
import br.com.docz.model.entity.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends JpaRepository <Documento, Integer>{

}