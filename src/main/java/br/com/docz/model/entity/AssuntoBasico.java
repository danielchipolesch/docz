package br.com.docz.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name="t_assunto_basico",
		uniqueConstraints = @UniqueConstraint(
		name = "uk_nome_numero_assunto_basico",
		columnNames = {"nm_assunto_basico", "nr_assunto_basico"})
	  )
@DynamicUpdate
@EqualsAndHashCode
@ToString
public class AssuntoBasico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cd_assunto_basico")
	private Integer codigoAssuntoBasico;
	
	@Column(name = "nm_assunto_basico", nullable = false, length = 150)
	private String nomeAssuntoBasico;
	
	@Column(name = "nr_assunto_basico", nullable = false)
	private Integer numeroAssuntoBasico;
	
	@Column(name = "dt_criacao", updatable = false)
	@CreationTimestamp
	private Timestamp dataCriacao;
	
	@Column(name = "dt_alteracao")
	@UpdateTimestamp
	private Timestamp dataAlteracao;
	
	@Column(name = "nr_versao")
	@Version
	private Integer numeroVersao;
	
	public Integer getCodigoAssuntoBasico() {
		return codigoAssuntoBasico;
	}
	
	public void setCodigoAssuntoBasico(Integer codigoAssuntoBasico) {
		this.codigoAssuntoBasico = codigoAssuntoBasico;
	}
	
	public String getNomeAssuntoBasico() {
		return nomeAssuntoBasico;
	}
	
	public void setNomeAssuntoBasico(String nomeAssuntoBasico) {
		this.nomeAssuntoBasico = nomeAssuntoBasico;
	}
	
	public Integer getNumeroAssuntoBasico() {
		return numeroAssuntoBasico;
	}
	
	public void setNumeroAssuntoBasico(Integer numeroAssuntoBasico) {
		this.numeroAssuntoBasico = numeroAssuntoBasico;
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
