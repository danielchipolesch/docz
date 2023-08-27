package br.com.docz.dto;


import br.com.docz.model.entity.Documento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Collection;
import java.util.List;

public record CapituloDto(Documento documento, String nomeCapitulo, String textoCapitulo) {

}
