package br.com.docz.Dto;

import jakarta.validation.constraints.NotBlank;

public record EspecieDto(@NotBlank String siglaEspecie, @NotBlank String nomeEspecie) {
}
