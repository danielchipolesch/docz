package br.com.docz.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.docz.model.entity.Especie;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Integer> {
}
