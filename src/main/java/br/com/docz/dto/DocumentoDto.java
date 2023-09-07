package br.com.docz.dto;


import br.com.docz.model.entity.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DocumentoDto(@NotBlank String nomeOrgao,
                           Especie especie,
                           AssuntoBasico assuntoBasico,
                           @NotBlank String nomeEpigrafeDocumento,
                           @NotNull Integer numeroSecundarioAssuntoBasico,
                           AtoAprovacao atoAprovacao,
                           Sumario sumario,
                           Prefacio prefacio,
                           Referencia referencia) {
}
