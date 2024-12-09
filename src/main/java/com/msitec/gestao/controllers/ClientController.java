package com.msitec.gestao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<ClientModel> saveClient(@RequestBody @Valid ClientRecordDto clientRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(clientRecordDto));
    }

    // @GetMapping("/search")
    // public Page<ClientModel> search(
    // @RequestParam("searchTerm") String searchTerm,
    // @RequestParam(value = "page", required = false, defaultValue = "0") int page,
    // @RequestParam(value = "size", required = false, defaultValue = "10") int
    // size) {
    // return clientService.search(searchTerm, page, size);
    // }

    @GetMapping
    public ResponseEntity<List<ClientModel>> getAllClients() {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll());
    }

    @GetMapping("/listar/paginando")
    public ResponseEntity<Page<ClientRecordDto>> listAllClientsPagination(Pageable pageable){
        Page<ClientRecordDto> page = clientService.listAllClientsPagination(pageable);
        if(page.getTotalElements() > 0){
            return ResponseEntity.status(HttpStatus.OK).body(page);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(page);
    }

    @GetMapping("/filtrar")
    public ResponseEntity<Page<ClientRecordDto>> filterClients(String nome, String cpf, Pageable pageable){
    //public Page<ClientRecordDto> filterClients(
    //     @RequestParam(required = false) String nome,
    //     @RequestParam(required = false) String cpf,
    //     Pageable pageable
    // ) {

        // if ((nome == null || nome.isBlank()) && (cpf == null || cpf.isBlank())) {
        //     return clientRepository.findAll(pageable).map(ClientRecordDto::new);
        // }

        // return clientRepository.findByNomeContainingIgnoreCaseOrCpfContaining(
        //     nome != null ? nome : "",
        //     cpf != null ? cpf : "",
        //     pageable
        //     ).map(ClientRecordDto::new);

        Page<ClientRecordDto> page = clientService.filterClientsByNomeOrCpf(nome, cpf, pageable);

        if (page.getTotalElements() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(page);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientModel> getOneClient(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientModel> updateClient(
            @PathVariable(value = "id") Long id,
            @RequestBody @Valid ClientRecordDto clientRecordDto) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.updateClient(id, clientRecordDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.deleteClient(id));
    }

    // @GetMapping("/search")
    // public ResponseEntity<List<ClientModel>> listClients(
    // @RequestParam int page,
    // @RequestParam int itens) {
    // return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll(page,
    // itens));
    // }

    // public List<ClientModel> listClients(Pageable pageable) {
    // return clientService.listClients(pageable).getContent();
    // }

}
