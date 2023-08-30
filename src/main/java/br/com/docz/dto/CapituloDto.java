package br.com.docz.dto;


import br.com.docz.model.entity.Documento;

public record CapituloDto(Documento documento, String nomeCapitulo, String textoCapitulo) {

}
