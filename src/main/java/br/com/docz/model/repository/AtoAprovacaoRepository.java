package br.com.docz.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.docz.model.entity.AtoAprovacao;


@Repository
public interface AtoAprovacaoRepository extends JpaRepository <AtoAprovacao, Integer>{

}
