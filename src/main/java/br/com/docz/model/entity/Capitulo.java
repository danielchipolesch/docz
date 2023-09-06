package br.com.docz.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "t_capitulo")
@DynamicUpdate
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
	
	public Integer getCodigoCapitulo() {
		return codigoCapitulo;
	}
	
	public void setCodigoCapitulo(Integer codigoCapitulo) {
		this.codigoCapitulo = codigoCapitulo;
	}
	
	public Documento getDocumento() {
		return documento;
	}
	
	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
	
	public String getNomeCapitulo() {
		return nomeCapitulo;
	}
	
	public void setNomeCapitulo(String nomeCapitulo) {
		this.nomeCapitulo = nomeCapitulo;
	}
	
	public String getTextoCapitulo() {
		return textoCapitulo;
	}
	
	public void setTextoCapitulo(String textoCapitulo) {
		this.textoCapitulo = textoCapitulo;
	}
	
	public Integer getNumeroOrdemCapitulo() {
		return numeroOrdemCapitulo;
	}
	
	public void setNumeroOrdemCapitulo(Integer numeroOrdemCapitulo) {
		this.numeroOrdemCapitulo = numeroOrdemCapitulo;
	}
	
	public Timestamp getDataCriacao() {
		return dataCriacao;
	}
	
	public void setDataCriacao(Timestamp dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public Timestamp getDataAlteracao() {
		return dataAlteracao;
	}
	
	public void setDataAlteracao(Timestamp dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	
	public Integer getNumeroVersao() {
		return numeroVersao;
	}
	
	public void setNumeroVersao(Integer numeroVersao) {
		this.numeroVersao = numeroVersao;
	}
}
