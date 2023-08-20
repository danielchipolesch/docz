package br.com.docz.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_ato_aprovacao")
@DynamicUpdate
public class AtoAprovacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_ato_aprovacao")
	private Integer codigoAtoAprovacao;
	
	@Column(name = "tx_ementa")
	private String textoEmenta;
	
	@Column(name = "tx_portaria")
	private String textoPortaria;
	
	@Column(name = "nm_autoridade")
	private String nomeAutoridade;
	
	@Column(name = "dt_criacao")
	@CreationTimestamp
	private Timestamp dataCriacao;
	
	@Column(name = "dt_alteracao")
	@UpdateTimestamp
	private Timestamp dataAlteracao;
	
	@Column(name = "nr_versao")
	@Version
	private Integer numeroVersao;
	
	public Integer getCodigoAtoAprovacao() {
		return codigoAtoAprovacao;
	}
	
	public void setCodigoAtoAprovacao(Integer codigoAtoAprovacao) {
		this.codigoAtoAprovacao = codigoAtoAprovacao;
	}
	
	public String getTextoEmenta() {
		return textoEmenta;
	}
	
	public void setTextoEmenta(String textoEmenta) {
		this.textoEmenta = textoEmenta;
	}
	
	public String getTextoPortaria() {
		return textoPortaria;
	}
	
	public void setTextoPortaria(String textoPortaria) {
		this.textoPortaria = textoPortaria;
	}
	
	public String getNomeAutoridade() {
		return nomeAutoridade;
	}
	
	public void setNomeAutoridade(String nomeAutoridade) {
		this.nomeAutoridade = nomeAutoridade;
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
		if (o == null || getClass() != o.getClass()) return false;
		AtoAprovacao that = (AtoAprovacao) o;
		return Objects.equals(codigoAtoAprovacao, that.codigoAtoAprovacao) && Objects.equals(textoEmenta, that.textoEmenta) && Objects.equals(textoPortaria, that.textoPortaria) && Objects.equals(nomeAutoridade, that.nomeAutoridade) && Objects.equals(dataCriacao, that.dataCriacao) && Objects.equals(dataAlteracao, that.dataAlteracao) && Objects.equals(numeroVersao, that.numeroVersao);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigoAtoAprovacao, textoEmenta, textoPortaria, nomeAutoridade, dataCriacao, dataAlteracao, numeroVersao);
	}
}
