package com.msitec.gestao.dtos;

import jakarta.validation.constraints.NotBlank;

public record ClientRecordDto(
    @NotBlank String nome,
    @NotBlank String cpf) {
}
