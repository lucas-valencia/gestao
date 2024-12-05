package com.msitec.gestao.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClientRecordDto(
    @NotBlank String nome,
    @NotBlank String cpf, 
    @NotNull LocalDateTime dataCriacao) {

}
