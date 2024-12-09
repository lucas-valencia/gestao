package com.msitec.gestao;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;

import com.msitec.gestao.dtos.ClientRecordDto;
import com.msitec.gestao.models.ClientModel;
import com.msitec.gestao.repositories.ClientRepository;
import com.msitec.gestao.services.ClientService;

public class UpdateClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientModel clientModel;

    @Autowired
    @InjectMocks
    private ClientService clientService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should update client successfully when nome and cpf was infoormed ok")
    void UpdateClientCaso1(){

        ClientModel client = new ClientModel(1L, "Teste0", "00000000001");
        
        when(clientRepository.findById(1L)).thenReturn(client);
    }

    @Test
    @DisplayName("Should thown Exception when nome and cpf was informed out of paramters")
    void UpdateClientCaso2(){

    }
    
}
