package br.com.docz.model.entity;
import br.com.docz.helper.StatusDocumento;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "t_documento")
@DynamicUpdate
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Documento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_documento")
	private Integer codigoDocumento;
	
	@Column(name = "nm_orgao")
	private String nomeOrgao;
	
	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_especie"))
	private Especie especie;
	
	@OneToOne
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
}
