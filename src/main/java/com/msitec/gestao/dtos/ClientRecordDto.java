package com.msitec.gestao.dtos;

import com.msitec.gestao.models.ClientModel;

import jakarta.validation.constraints.NotBlank;

public record ClientRecordDto(
    @NotBlank String nome,
    @NotBlank String cpf) {

    public ClientRecordDto(ClientModel client){
        this(
            client.getNome(),
            client.getCpf()
        );
    }

    public ClientRecordDto(String nome, String cpf){

        this.nome = nome;
        this.cpf = cpf;
    }

}
