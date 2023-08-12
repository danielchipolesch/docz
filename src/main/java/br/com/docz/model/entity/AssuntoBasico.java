package br.com.docz.model.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="t_assunto_basico")
public class AssuntoBasico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cd_assunto_basico")
	private Integer codigoAssuntoBasico;
	
	@Column(name = "nm_assunto_basico", nullable = false, length = 150)
	private String nomeAssuntoBasico;
	
	@Column(name = "nr_assunto_basico", nullable = false)
	private Integer numeroAssuntoBasico;
	
	public Integer getCodigoAssuntoBasico() {
		return codigoAssuntoBasico;
	}
	
	public void setCodigoAssuntoBasico(Integer codigoAssuntoBasico) {
		this.codigoAssuntoBasico = codigoAssuntoBasico;
	}
	
	public String getNomeAssuntoBasico() {
		return nomeAssuntoBasico;
	}
	
	public void setNomeAssuntoBasico(String nomeAssuntoBasico) {
		this.nomeAssuntoBasico = nomeAssuntoBasico;
	}
	
	public Integer getNumeroAssuntoBasico() {
		return numeroAssuntoBasico;
	}
	
	public void setNumeroAssuntoBasico(Integer numeroAssuntoBasico) {
		this.numeroAssuntoBasico = numeroAssuntoBasico;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AssuntoBasico that = (AssuntoBasico) o;
		return Objects.equals(codigoAssuntoBasico, that.codigoAssuntoBasico) && Objects.equals(nomeAssuntoBasico, that.nomeAssuntoBasico) && Objects.equals(numeroAssuntoBasico, that.numeroAssuntoBasico);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigoAssuntoBasico, nomeAssuntoBasico, numeroAssuntoBasico);
	}
}
