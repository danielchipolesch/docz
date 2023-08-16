package br.com.docz.dto;

import jakarta.validation.constraints.NotBlank;

public record EspecieDto(@NotBlank String siglaEspecie, @NotBlank String nomeEspecie) {
}
