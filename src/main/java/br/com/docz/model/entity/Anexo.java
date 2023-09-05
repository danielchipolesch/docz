package br.com.docz.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "t_anexo")
@DynamicUpdate
@Getter
@Setter
@EqualsAndHashCode
@ToString
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
}
