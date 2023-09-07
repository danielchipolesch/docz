package br.com.docz.model.entity;
import br.com.docz.helper.StatusDocumento;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "t_documento")
@DynamicUpdate
@EqualsAndHashCode
@ToString
public class Documento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_documento")
	private Integer codigoDocumento;
	
	@Column(name = "nm_orgao")
	private String nomeOrgao;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_especie"))
	private Especie especie;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_assunto_basico"))
	private AssuntoBasico assuntoBasico;
	
	@Column(name = "nm_epigrafe_documento")
	private String nomeEpigrafeDocumento;
	
	@Column(name = "nr_secundario_assunto_basico")
	private Integer numeroSecundarioAssuntoBasico;
	
	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_ato_aprovacao"))
	private AtoAprovacao atoAprovacao;
	
	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_sumario"))
	private Sumario sumario;
	
	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_prefacio"))
	private Prefacio prefacio;
	
	@OneToMany (mappedBy = "documento", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	@JsonManagedReference
	@OrderBy("nr_ordem_capitulo ASC")
	private List<Capitulo> capitulos = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_referencia"))
	private Referencia referencia;
	
	@OneToMany (mappedBy = "documento", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
	@JsonManagedReference
	private List<Anexo> anexos = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	private StatusDocumento statusDocumento;
	
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
	
	public String getNomeOrgao() {
		return nomeOrgao;
	}
	
	public void setNomeOrgao(String nomeOrgao) {
		this.nomeOrgao = nomeOrgao;
	}
	
	public Especie getEspecie() {
		return especie;
	}
	
	public void setEspecie(Especie especie) {
		this.especie = especie;
	}
	
	public AssuntoBasico getAssuntoBasico() {
		return assuntoBasico;
	}
	
	public void setAssuntoBasico(AssuntoBasico assuntoBasico) {
		this.assuntoBasico = assuntoBasico;
	}
	
	public String getNomeEpigrafeDocumento() {
		return nomeEpigrafeDocumento;
	}
	
	public void setNomeEpigrafeDocumento(String nomeEpigrafeDocumento) {
		this.nomeEpigrafeDocumento = nomeEpigrafeDocumento;
	}
	
	public Integer getNumeroSecundarioAssuntoBasico() {
		return numeroSecundarioAssuntoBasico;
	}
	
	public void setNumeroSecundarioAssuntoBasico(Integer numeroSecundarioAssuntoBasico) {
		this.numeroSecundarioAssuntoBasico = numeroSecundarioAssuntoBasico;
	}
	
	public AtoAprovacao getAtoAprovacao() {
		return atoAprovacao;
	}
	
	public void setAtoAprovacao(AtoAprovacao atoAprovacao) {
		this.atoAprovacao = atoAprovacao;
	}
	
	public Sumario getSumario() {
		return sumario;
	}
	
	public void setSumario(Sumario sumario) {
		this.sumario = sumario;
	}
	
	public Prefacio getPrefacio() {
		return prefacio;
	}
	
	public void setPrefacio(Prefacio prefacio) {
		this.prefacio = prefacio;
	}
	
	public List<Capitulo> getCapitulos() {
		return capitulos;
	}
	
	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}
	
	public Referencia getReferencia() {
		return referencia;
	}
	
	public void setReferencia(Referencia referencia) {
		this.referencia = referencia;
	}
	
	public List<Anexo> getAnexos() {
		return anexos;
	}
	
	public void setAnexos(List<Anexo> anexos) {
		this.anexos = anexos;
	}
	
	public StatusDocumento getStatusDocumento() {
		return statusDocumento;
	}
	
	public void setStatusDocumento(StatusDocumento statusDocumento) {
		this.statusDocumento = statusDocumento;
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
