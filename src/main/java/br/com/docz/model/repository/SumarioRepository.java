package br.com.docz.model.repository;

import br.com.docz.model.entity.Sumario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SumarioRepository extends JpaRepository <Sumario, Integer>{

}
