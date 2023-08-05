package br.com.docz.model.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="t_documento", schema="documento")

public class Documento {
	
	@Id
	@Column(name="cd_documento")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private UUID id;
	
	@Column(name="nm_orgao", nullable = false)
	private String nomeOrgao;

	//@OneToMany(mappedBy = "cd_especie")
	@Column(name = "cd_especie")
	private Long especieDocumento;

	//@OneToMany(mappedBy = "cd_assunto_basico")
	@Column(name = "cd_assunto_basico")
	private Long assuntoBasico;

	@Column(name="nm_titulo_documento", nullable = false)
	private String nomeTituloDocumento;

	@Column(name = "nr_secundario_assunto")
	private String numeroSecundarioAssunto;
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getNomeOrgao() {
		return nomeOrgao;
	}
	
	public void setNomeOrgao(String nomeOrgao) {
		this.nomeOrgao = nomeOrgao;
	}
	
	public Long getEspecieDocumento() {
		return especieDocumento;
	}
	
	public void setEspecieDocumento(Long especieDocumento) {
		this.especieDocumento = especieDocumento;
	}
	
	public Long getAssuntoBasico() {
		return assuntoBasico;
	}
	
	public void setAssuntoBasico(Long assuntoBasico) {
		this.assuntoBasico = assuntoBasico;
	}
	
	public String getNomeTituloDocumento() {
		return nomeTituloDocumento;
	}
	
	public void setNomeTituloDocumento(String nomeTituloDocumento) {
		this.nomeTituloDocumento = nomeTituloDocumento;
	}
	
	public String getNumeroSecundarioAssunto() {
		return numeroSecundarioAssunto;
	}
	
	public void setNumeroSecundarioAssunto(String numeroSecundarioAssunto) {
		this.numeroSecundarioAssunto = numeroSecundarioAssunto;
	}
}
