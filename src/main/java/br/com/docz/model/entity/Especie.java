package br.com.docz.model.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_especie", uniqueConstraints = @UniqueConstraint(
		name = "uk_sigla_nome_especie",
		columnNames = {"sg_especie", "nm_especie"}
      ))
@DynamicUpdate
@EqualsAndHashCode
@ToString
public class Especie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_especie")
	private Integer codigoEspecie;
	
	@Column(name = "sg_especie", nullable = false)
	private String siglaEspecie;
	
	@Column(name = "nm_especie", nullable = false)
	private String nomeEspecie;
	
	@Column(name = "dt_criacao", updatable = false)
	@CreationTimestamp
	private Timestamp dataCriacao;
	
	@Column(name = "dt_alteracao")
	@UpdateTimestamp
	private Timestamp dataAlteracao;
	
	@Column(name = "nr_versao")
	@Version
	private Integer numeroVersao;
	
	public Integer getCodigoEspecie() {
		return codigoEspecie;
	}
	
	public void setCodigoEspecie(Integer codigoEspecie) {
		this.codigoEspecie = codigoEspecie;
	}
	
	public String getSiglaEspecie() {
		return siglaEspecie;
	}
	
	public void setSiglaEspecie(String siglaEspecie) {
		this.siglaEspecie = siglaEspecie;
	}
	
	public String getNomeEspecie() {
		return nomeEspecie;
	}
	
	public void setNomeEspecie(String nomeEspecie) {
		this.nomeEspecie = nomeEspecie;
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
