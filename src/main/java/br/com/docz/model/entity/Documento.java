package br.com.docz.model.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "t_documento")
@DynamicUpdate
public class Documento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_documento")
	private Integer codigoDocumento;
	
	@Column(name = "tx_documento")
	private String textoDocumento;
	
	@OneToMany (mappedBy = "documento", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	@JsonManagedReference
	private List<Capitulo> capitulos = new ArrayList<>();
	
	@Column(name = "dt_criacao", updatable = false)
	@CreationTimestamp
	private Timestamp dataCriacao;
	
	@Column(name = "dt_alteracao")
	@UpdateTimestamp
	private Timestamp dataAlteracao;
	
	@Column(name = "nr_versao")
	@Version
	private Integer numeroVersao;
	
	public Integer getCodigoDocumento() {
		return codigoDocumento;
	}
	
	public void setCodigoDocumento(Integer codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}
	
	public String getTextoDocumento() {
		return textoDocumento;
	}
	
	public void setTextoDocumento(String textoDocumento) {
		this.textoDocumento = textoDocumento;
	}
	
	public List<Capitulo> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
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
