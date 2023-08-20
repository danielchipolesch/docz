package br.com.docz.dto;

import jakarta.validation.constraints.NotBlank;

public record AssuntoBasicoDto(@NotBlank String nomeAssuntoBasico,@NotBlank String numeroAssuntoBasico) {

}
