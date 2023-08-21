package br.com.docz.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_prefacio")
@DynamicUpdate
public class Prefacio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_sumario")
	private Integer codigoPrefacio;
	
	@Column(name = "tx_sumario")
	private String textoPrefacio;
	
	@Column(name = "dt_criacao", updatable = false)
	@CreationTimestamp
	private Timestamp dataCriacao;
	
	@Column(name = "dt_alteracao")
	@UpdateTimestamp
	private Timestamp dataAlteracao;
	
	@Column(name = "nr_versao")
	@Version
	private Integer numeroVersao;
	
	public Integer getCodigoPrefacio() {
		return codigoPrefacio;
	}
	
	public void setCodigoPrefacio(Integer codigoPrefacio) {
		this.codigoPrefacio = codigoPrefacio;
	}
	
	public String getTextoPrefacio() {
		return textoPrefacio;
	}
	
	public void setTextoPrefacio(String textoPrefacio) {
		this.textoPrefacio = textoPrefacio;
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
		if (!(o instanceof Prefacio)) return false;
		Prefacio prefacio = (Prefacio) o;
		return Objects.equals(getCodigoPrefacio(), prefacio.getCodigoPrefacio()) && Objects.equals(getTextoPrefacio(), prefacio.getTextoPrefacio()) && Objects.equals(getDataCriacao(), prefacio.getDataCriacao()) && Objects.equals(getDataAlteracao(), prefacio.getDataAlteracao()) && Objects.equals(getNumeroVersao(), prefacio.getNumeroVersao());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getCodigoPrefacio(), getTextoPrefacio(), getDataCriacao(), getDataAlteracao(), getNumeroVersao());
	}
	
	@Override
	public String toString() {
		return "Prefacio{" +
				"codigoPrefacio=" + codigoPrefacio +
				", textoPrefacio='" + textoPrefacio + '\'' +
				", dataCriacao=" + dataCriacao +
				", dataAlteracao=" + dataAlteracao +
				", numeroVersao=" + numeroVersao +
				'}';
	}
}
