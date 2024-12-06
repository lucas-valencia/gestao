package com.msitec.gestao.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msitec.gestao.dtos.ClientRecordDto;
import com.msitec.gestao.models.ClientModel;
import com.msitec.gestao.repositories.ClientRepository;
import com.msitec.gestao.exceptions.ClientAlreadyExistsException;
import com.msitec.gestao.exceptions.ClientNoFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientServiceImpl(){

    }

    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientModel> findAll(){
        return clientRepository.findAll();
    }

    @Override
    public ClientModel getById(Long id){
        Optional<ClientModel> client = clientRepository.findById(id);
        if(client.isEmpty()) {
            throw new ClientNoFoundException("Cliente não encontrado");
        }
        return client.get();
    }

    @Override
    public ClientModel save(ClientRecordDto clientRecordDto){
        
        String cpf = clientRecordDto.cpf();
        if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("O CPF deve conter exatamente 11 dígitos numéricos");
        }
        
        if (clientRepository.existsByCpf(clientRecordDto.cpf())) {
            throw new ClientAlreadyExistsException("Cliente com CPF já cadastrado");
        }

        var client = new ClientModel();
        BeanUtils.copyProperties(clientRecordDto, client);
        client.setDataCriacao(LocalDateTime.now());

        return clientRepository.save(client);
    }

    @Override
    public ClientModel updateClient(Long id, ClientRecordDto clientRecordDto){
        Optional<ClientModel> client = clientRepository.findById(id);
        if (client.isEmpty()) {
            throw new ClientNoFoundException("Cliente não encontrado");
        }
        var clientModel = client.get();
        BeanUtils.copyProperties(clientRecordDto, clientModel);
        return clientRepository.save(clientModel);
    }

    @Override
    public String deleteClient(Long id){
        Optional<ClientModel> client = clientRepository.findById(id);
        if (client.isEmpty()) {
            throw new ClientNoFoundException("Cliente não encontrado");
        }
        clientRepository.delete(client.get());
        return "Cliente deletado com sucesso!";
    }

}
