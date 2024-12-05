package com.msitec.gestao.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.msitec.gestao.dtos.ClientRecordDto;
import com.msitec.gestao.models.ClientModel;
import com.msitec.gestao.repositories.ClientRepository;

import jakarta.validation.Valid;

@RestController
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @PostMapping("/clients")
    public ResponseEntity<ClientModel> saveClient(@RequestBody @Valid ClientRecordDto clientRecordDto){
        var clientModel = new ClientModel();
        BeanUtils.copyProperties(clientRecordDto, clientModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientRepository.save(clientModel));
    }

    @GetMapping("/clients")
    public ResponseEntity<List<ClientModel>> getAllClients(){
        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.findAll());
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Object> getOneClient(@PathVariable(value = "id") Long id){
        Optional<ClientModel> client0 = clientRepository.findById(id);
        if (client0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(client0.get());
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable(value = "id") Long id, @RequestBody @Valid ClientRecordDto clientRecordDto) {
        Optional<ClientModel> client0 = clientRepository.findById(id);
        if (client0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
        var clientModel = client0.get();
        BeanUtils.copyProperties(clientRecordDto, clientModel);
        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.save(clientModel));
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable(value="id") Long id){
        Optional<ClientModel> client0 = clientRepository.findById(id);
        if (client0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
        clientRepository.delete(client0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso!");
    }

}
