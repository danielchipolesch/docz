package br.com.docz.model.repository;

import br.com.docz.model.entity.Prefacio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrefacioRepository extends JpaRepository <Prefacio, Integer>{

}
