package br.com.docz.model.repository;

import br.com.docz.model.entity.Referencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenciaRepository extends JpaRepository <Referencia, Integer>{

}
