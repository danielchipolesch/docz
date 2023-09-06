package br.com.docz.dto;

import jakarta.validation.constraints.NotBlank;

public record EspecieDto(String siglaEspecie, String nomeEspecie) {
}
