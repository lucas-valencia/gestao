package com.msitec.gestao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msitec.gestao.models.ClientModel;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long>{

}
