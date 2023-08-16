package br.com.docz.model.repository;

import br.com.docz.model.entity.AssuntoBasico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssuntoBasicoRepository extends JpaRepository <AssuntoBasico, Integer> {
}
