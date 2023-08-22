package br.com.docz.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_referencia")
@DynamicUpdate
public class Referencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_referencia")
	private Integer codigoReferencia;
	
	@Column(name = "tx_referencia")
	private String textoReferencia;
	
	@Column(name = "dt_criacao", updatable = false)
	@CreationTimestamp
	private Timestamp dataCriacao;
	
	@Column(name = "dt_alteracao")
	@UpdateTimestamp
	private Timestamp dataAlteracao;
	
	@Column(name = "nr_versao")
	@Version
	private Integer numeroVersao;
	
	public Integer getCodigoReferencia() {
		return codigoReferencia;
	}
	
	public void setCodigoReferencia(Integer codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}
	
	public String getTextoReferencia() {
		return textoReferencia;
	}
	
	public void setTextoReferencia(String textoReferencia) {
		this.textoReferencia = textoReferencia;
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
		if (!(o instanceof Referencia)) return false;
		Referencia prefacio = (Referencia) o;
		return Objects.equals(getCodigoReferencia(), prefacio.getCodigoReferencia()) && Objects.equals(getTextoReferencia(), prefacio.getTextoReferencia()) && Objects.equals(getDataCriacao(), prefacio.getDataCriacao()) && Objects.equals(getDataAlteracao(), prefacio.getDataAlteracao()) && Objects.equals(getNumeroVersao(), prefacio.getNumeroVersao());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getCodigoReferencia(), getTextoReferencia(), getDataCriacao(), getDataAlteracao(), getNumeroVersao());
	}
	
	@Override
	public String toString() {
		return "Referencia{" +
				"codigoReferencia=" + codigoReferencia +
				", textoReferencia='" + textoReferencia + '\'' +
				", dataCriacao=" + dataCriacao +
				", dataAlteracao=" + dataAlteracao +
				", numeroVersao=" + numeroVersao +
				'}';
	}
}
