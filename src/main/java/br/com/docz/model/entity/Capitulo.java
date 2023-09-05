package br.com.docz.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "t_capitulo")
@DynamicUpdate
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Capitulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_capitulo")
	private Integer codigoCapitulo;
	
	@ManyToOne
	@JoinColumn(name = "cd_documento", updatable = false, nullable = false)
	@JsonBackReference
	private Documento documento;
	
	@Column(name = "nm_capitulo", nullable = false)
	private String nomeCapitulo;
	
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
