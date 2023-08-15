package br.com.docz.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;


public record AssuntoBasicoDto(@NotBlank String nomeAssuntoBasico, @NotNull String numeroAssuntoBasico) {

}
