package br.com.docz.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_anexo")
@DynamicUpdate
public class Anexo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_anexo")
	private Integer codigoAnexo;
	
	@ManyToOne
	@JoinColumn(name = "cd_documento", updatable = false, nullable = true)
	@JsonBackReference
	private Documento documento;
	
	@Column(name = "nm_anexo", nullable = false)
	private String nomeAnexo;
	
	@Column(name = "tx_anexo")
	private String textoAnexo;
	
	@Column(name = "dt_criacao", updatable = false)
	@CreationTimestamp
	private Timestamp dataCriacao;
	
	@Column(name = "dt_alteracao")
	@UpdateTimestamp
	private Timestamp dataAlteracao;
	
	@Column(name = "nr_versao")
	@Version
	private Integer numeroVersao;
	
	public Integer getCodigoAnexo() {
		return codigoAnexo;
	}
	
	public void setCodigoAnexo(Integer codigoAnexo) {
		this.codigoAnexo = codigoAnexo;
	}
	
	public Documento getDocumento() {
		return documento;
	}
	
	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
	
	public String getNomeAnexo() {
		return nomeAnexo;
	}
	
	public void setNomeAnexo(String nomeAnexo) {
		this.nomeAnexo = nomeAnexo;
	}
	
	public String getTextoAnexo() {
		return textoAnexo;
	}
	
	public void setTextoAnexo(String textoAnexo) {
		this.textoAnexo = textoAnexo;
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
		if (!(o instanceof Anexo)) return false;
		Anexo anexo = (Anexo) o;
		return Objects.equals(getCodigoAnexo(), anexo.getCodigoAnexo()) && Objects.equals(getDocumento(), anexo.getDocumento()) && Objects.equals(getNomeAnexo(), anexo.getNomeAnexo()) && Objects.equals(getTextoAnexo(), anexo.getTextoAnexo()) && Objects.equals(getDataCriacao(), anexo.getDataCriacao()) && Objects.equals(getDataAlteracao(), anexo.getDataAlteracao()) && Objects.equals(getNumeroVersao(), anexo.getNumeroVersao());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getCodigoAnexo(), getDocumento(), getNomeAnexo(), getTextoAnexo(), getDataCriacao(), getDataAlteracao(), getNumeroVersao());
	}
	
	@Override
	public String toString() {
		return "Anexo{" +
				"codigoAnexo=" + codigoAnexo +
				", documento=" + documento +
				", nomeAnexo='" + nomeAnexo + '\'' +
				", textoAnexo='" + textoAnexo + '\'' +
				", dataCriacao=" + dataCriacao +
				", dataAlteracao=" + dataAlteracao +
				", numeroVersao=" + numeroVersao +
				'}';
	}
}
