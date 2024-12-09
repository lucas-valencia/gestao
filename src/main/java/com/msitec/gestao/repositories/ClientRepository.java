package com.msitec.gestao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msitec.gestao.models.ClientModel;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long>{
    boolean existsByCpf(String cpf);
    //  Page<ClientModel> findByNomeContainingOrCpf(String nome, String cpf, Pageable pageable);
    Page<ClientModel> findByNomeContainingIgnoreCaseOrCpfContaining(String nome, String cpf, Pageable pageable);

}
