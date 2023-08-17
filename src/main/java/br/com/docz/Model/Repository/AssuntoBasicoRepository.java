package br.com.docz.Model.Repository;

import br.com.docz.Model.Entity.AssuntoBasico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssuntoBasicoRepository extends JpaRepository <AssuntoBasico, Integer> {
}
