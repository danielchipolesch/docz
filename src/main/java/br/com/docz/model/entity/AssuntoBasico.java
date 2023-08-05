package br.com.docz.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="t_assunto_basico", schema="documento")
public class AssuntoBasico {
	
	@Id
	@Column(name = "cd_assunto_basico")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nm_assunto_basico")
	private String nomeAssuntoBasico;
	
	@Column(name = "nr_assunto_basico")
	private String numeroAssuntoBasico;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNomeAssuntoBasico() {
		return nomeAssuntoBasico;
	}
	
	public void setNomeAssuntoBasico(String nomeAssuntoBasico) {
		this.nomeAssuntoBasico = nomeAssuntoBasico;
	}
	
	public String getNumeroAssuntoBasico() {
		return numeroAssuntoBasico;
	}
	
	public void setNumeroAssuntoBasico(String numeroAssuntoBasico) {
		this.numeroAssuntoBasico = numeroAssuntoBasico;
	}
}
