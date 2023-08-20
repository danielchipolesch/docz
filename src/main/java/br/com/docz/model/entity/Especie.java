package br.com.docz.model.entity;

import jakarta.persistence.*;
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
	
	public Integer getNumeroversao() {
		return numeroVersao;
	}
	
	public void setNumeroversao(Integer numeroVersao) {
		this.numeroVersao = numeroVersao;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Especie that = (Especie) o;
		return Objects.equals(codigoEspecie, that.codigoEspecie) && Objects.equals(siglaEspecie, that.siglaEspecie) && Objects.equals(nomeEspecie, that.nomeEspecie) && Objects.equals(dataCriacao, that.dataCriacao) && Objects.equals(dataAlteracao, that.dataAlteracao) && Objects.equals(numeroVersao, that.numeroVersao);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigoEspecie, siglaEspecie, nomeEspecie, dataCriacao, dataAlteracao, numeroVersao);
	}
}
