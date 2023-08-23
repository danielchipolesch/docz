package br.com.docz.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_capitulo")
@DynamicUpdate
public class Capitulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_capitulo")
	private Integer codigoCapitulo;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "cd_documento", nullable = false, updatable = false)
	private Documento documento;
	
	@Column(name = "tx_capitulo")
	private String textoCapitulo;
	
	@Column(name = "nr_ordem_capitulo")
	private Integer numeroOrdemCapitulo;
	
	@Column(name = "dt_criacao", updatable = false)
	@CreationTimestamp
	private Timestamp dataCriacao;
	
	@Column(name = "dt_alteracao")
	@UpdateTimestamp
	private Timestamp dataAlteracao;
	
	@Column(name = "nr_versao")
	@Version
	private Integer numeroVersao;
	
}
