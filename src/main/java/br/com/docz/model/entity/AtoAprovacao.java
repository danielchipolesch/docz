package br.com.docz.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_ato_aprovacao")
@DynamicUpdate
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class AtoAprovacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_ato_aprovacao")
	private Integer codigoAtoAprovacao;
	
	@Column(name = "nr_portaria")
	private String numeroPortaria;
	
	@Column(name = "tx_ementa")
	private String textoEmenta;
	
	@Column(name = "tx_portaria")
	private String textoPortaria;
	
	@Column(name = "nm_autoridade")
	private String nomeAutoridade;
	
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
