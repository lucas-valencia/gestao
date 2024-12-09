package com.msitec.gestao.dtos;

import java.time.LocalDateTime;

import com.msitec.gestao.models.ClientModel;

import jakarta.validation.constraints.NotBlank;

public record ClientRecordDto(
    @NotBlank String nome,
    @NotBlank String cpf,
    LocalDateTime dataCriacao) {

    public ClientRecordDto(ClientModel client){
        this(
            client.getNome(),
            client.getCpf(),
            client.getDataCriacao()
        );
    }
}
