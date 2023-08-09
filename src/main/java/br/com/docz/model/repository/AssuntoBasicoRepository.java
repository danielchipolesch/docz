package br.com.docz.model.repository;

import br.com.docz.model.entity.AssuntoBasico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface AssuntoBasicoRepository extends JpaRepository <AssuntoBasico, Long> {

}
