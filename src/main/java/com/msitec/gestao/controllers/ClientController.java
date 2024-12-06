package com.msitec.gestao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msitec.gestao.dtos.ClientRecordDto;
import com.msitec.gestao.models.ClientModel;
import com.msitec.gestao.repositories.ClientRepository;
import com.msitec.gestao.services.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;
    
    @Autowired
    ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientModel> saveClient(@RequestBody @Valid ClientRecordDto clientRecordDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(clientRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<ClientModel>> getAllClients(){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientModel> getOneClient(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClient(
            @PathVariable(value = "id") Long id,
            @RequestBody @Valid ClientRecordDto clientRecordDto) {
                return ResponseEntity.status(HttpStatus.OK).body(clientService.updateClient(id, clientRecordDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable(value="id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.deleteClient(id));
    }



}
