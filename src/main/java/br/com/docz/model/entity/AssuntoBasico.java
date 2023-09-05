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
@Table(name="t_assunto_basico", uniqueConstraints = @UniqueConstraint(
		name = "uk_nome_numero_assunto_basico",
		columnNames = {"nm_assunto_basico", "nr_assunto_basico"}
))
@DynamicUpdate
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class AssuntoBasico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cd_assunto_basico")
	private Integer codigoAssuntoBasico;
	
	@Column(name = "nm_assunto_basico", nullable = false, length = 150)
	private String nomeAssuntoBasico;
	
	@Column(name = "nr_assunto_basico", nullable = false)
	private String numeroAssuntoBasico;
	
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
