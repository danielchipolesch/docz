package br.com.docz.dto;

import br.com.docz.model.entity.Documento;

public record AnexoDto(Documento documento, String nomeAnexo, String textoAnexo) {

}
