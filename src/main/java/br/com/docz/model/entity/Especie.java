package br.com.docz.model.entity;

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
@Table(name = "t_especie", uniqueConstraints = @UniqueConstraint(
		name = "uk_sigla_nome_especie",
		columnNames = {"sg_especie", "nm_especie"}
      ))
@DynamicUpdate
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Especie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_especie")
	private Integer codigoEspecie;
	
	@Column(name = "sg_especie", nullable = false)
	private String siglaEspecie;
	
	@Column(name = "nm_especie", nullable = false)
	private String nomeEspecie;
	
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
