package br.com.docz.Dto;

import jakarta.validation.constraints.NotBlank;

public record AssuntoBasicoDto(@NotBlank String nomeAssuntoBasico,@NotBlank String numeroAssuntoBasico) {

}
