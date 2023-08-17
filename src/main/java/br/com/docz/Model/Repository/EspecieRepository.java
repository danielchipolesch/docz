package br.com.docz.Model.Repository;

import br.com.docz.Model.Entity.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Integer> {
}
