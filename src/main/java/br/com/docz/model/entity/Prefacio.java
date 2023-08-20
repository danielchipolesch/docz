package br.com.docz.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_sumario")
@DynamicUpdate
public class Sumario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_sumario")
	private Integer codigoSumario;
	
	@Column(name = "tx_sumario")
	private String textoSumario;
	
	@Column(name = "dt_criacao", updatable = false)
	@CreationTimestamp
	private Timestamp dataCriacao;
	
	@Column(name = "dt_alteracao")
	@UpdateTimestamp
	private Timestamp dataAlteracao;
	
	@Column(name = "nr_versao")
	@Version
	private Integer numeroVersao;
	
	public Integer getCodigoSumario() {
		return codigoSumario;
	}
	
	public void setCodigoSumario(Integer codigoSumario) {
		this.codigoSumario = codigoSumario;
	}
	
	public String getTextoSumario() {
		return textoSumario;
	}
	
	public void setTextoSumario(String textoSumario) {
		this.textoSumario = textoSumario;
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
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Sumario)) return false;
		Sumario sumario = (Sumario) o;
		return Objects.equals(getCodigoSumario(), sumario.getCodigoSumario()) && Objects.equals(getTextoSumario(), sumario.getTextoSumario()) && Objects.equals(getDataCriacao(), sumario.getDataCriacao()) && Objects.equals(getDataAlteracao(), sumario.getDataAlteracao()) && Objects.equals(getNumeroVersao(), sumario.getNumeroVersao());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getCodigoSumario(), getTextoSumario(), getDataCriacao(), getDataAlteracao(), getNumeroVersao());
	}
}
