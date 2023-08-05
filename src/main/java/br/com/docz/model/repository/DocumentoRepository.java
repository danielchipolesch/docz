package br.com.docz.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.docz.model.entity.Documento;

import java.util.UUID;

public interface DocumentoRepository extends JpaRepository<Documento, UUID>{

}
