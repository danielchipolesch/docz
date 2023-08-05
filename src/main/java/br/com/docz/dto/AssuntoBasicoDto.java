package br.com.docz.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AssuntoBasicoDto(@NotBlank String NomeAssuntoBasico, @NotNull String NumeroAssuntoBasico) {

}
