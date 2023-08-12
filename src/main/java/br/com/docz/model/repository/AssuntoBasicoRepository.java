package br.com.docz.model.repository;

import br.com.docz.model.entity.AssuntoBasicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssuntoBasicoRepository extends JpaRepository <AssuntoBasicoModel, Integer> {

}
