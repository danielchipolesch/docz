package br.com.docz.model.repository;

import br.com.docz.model.entity.Capitulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapituloRepository extends JpaRepository <Capitulo, Integer>{

}
