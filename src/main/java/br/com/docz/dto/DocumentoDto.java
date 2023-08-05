package br.com.docz.dto;

import java.util.UUID;

public class DocumentoDto {

	private UUID id;
	
	private String nomeDocumento;
	
	private String tipoDocumento;
	
	private Integer numeroTipoDocumento;
	
	
	public DocumentoDto() {
		super();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getNomeDocumento() {
		return nomeDocumento;
	}
	
	public void setNomeDocumento(String nomeDocumento) {
		this.nomeDocumento = nomeDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Integer getNumeroTipoDocumento() {
		return numeroTipoDocumento;
	}

	public void setNumeroTipoDocumento(Integer numeroTipoDocumento) {
		this.numeroTipoDocumento = numeroTipoDocumento;
	}

			
}
