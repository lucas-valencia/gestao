package com.msitec.gestao.services;

import java.util.List;

import com.msitec.gestao.dtos.ClientRecordDto;
import com.msitec.gestao.models.ClientModel;

public interface ClientService {

    List<ClientModel> findAll();
    ClientModel getById(Long id);
    ClientModel save(ClientRecordDto clientRecordDto);
    ClientModel updateClient(Long id, ClientRecordDto clientRecordDto);
    String deleteClient(Long id);

}
