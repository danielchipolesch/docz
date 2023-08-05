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
	private String NomeAssuntoBasico;
	
	@Column(name = "nr_assunto_basico")
	private String NumeroAssuntoBasico;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNomeAssuntoBasico() {
		return NomeAssuntoBasico;
	}
	
	public void setNomeAssuntoBasico(String nomeAssuntoBasico) {
		NomeAssuntoBasico = nomeAssuntoBasico;
	}
	
	public String getNumeroAssuntoBasico() {
		return NumeroAssuntoBasico;
	}
	
	public void setNumeroAssuntoBasico(String numeroAssuntoBasico) {
		NumeroAssuntoBasico = numeroAssuntoBasico;
	}
}
