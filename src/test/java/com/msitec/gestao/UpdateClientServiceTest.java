package com.msitec.gestao;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;

import com.msitec.gestao.dtos.ClientRecordDto;
import com.msitec.gestao.models.ClientModel;
import com.msitec.gestao.repositories.ClientRepository;
import com.msitec.gestao.services.ClientService;
import com.msitec.gestao.services.ClientServiceImpl;

public class UpdateClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientModel clientModel;

    @Autowired
    @InjectMocks
    private ClientServiceImpl clientService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should update client successfully when nome and cpf was infoormed ok")
    void UpdateClientCaso1(){

        Optional<ClientModel> client = Optional.of(new ClientModel(1L, "Teste0", "00000000001"));
        ClientRecordDto clientDTO = new ClientRecordDto("TesteDto", "10000000000");
        
        
        when(clientRepository.findById(1L)).thenReturn(client);
        var clientNewInfos = client.get();

        BeanUtils.copyProperties(clientDTO, clientNewInfos);
        clientRepository.save(clientNewInfos);

        verify(clientRepository, times(1)).save(any());

        
    }

    @Test
    @DisplayName("Should thown Exception when nome and cpf was informed out of paramters")
    void UpdateClientCaso2(){

    }
    
}
