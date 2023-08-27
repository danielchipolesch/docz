package br.com.docz.model.repository;

import br.com.docz.model.entity.Anexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnexoRepository extends JpaRepository <Anexo, Integer>{

}
