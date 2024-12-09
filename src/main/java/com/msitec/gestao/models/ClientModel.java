package com.msitec.gestao.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.msitec.gestao.dtos.ClientRecordDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "table_clients")
public class ClientModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long idClient;
    @Column(name = "nome", length = 200)
    private String nome;
    @Column(name = "cpf", length = 11, unique = true)
    private String cpf;
    @Column(name = "dataCriacao")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime dataCriacao;

    public ClientModel(Long l, String nome, String cpf) {
        this.dataCriacao = LocalDateTime.now();
    }

    public ClientModel(){
        
    }

    public ClientModel(ClientRecordDto clientDto){
        this.nome = clientDto.nome();
        this.cpf = clientDto.cpf();
        this.dataCriacao = LocalDateTime.now();
    }

    public Long getIdClient() {
        return idClient;
    }
    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }


    
}
