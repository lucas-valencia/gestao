package com.msitec.gestao;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import com.msitec.gestao.dtos.ClientRecordDto;
import com.msitec.gestao.models.ClientModel;
import com.msitec.gestao.repositories.ClientRepository;
import com.msitec.gestao.services.ClientService;


import jakarta.persistence.EntityManager;

@SpringBootTest
@ActiveProfiles("test")
class GestaoApplicationTests {

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	ClientService clientService;

	@Autowired
	EntityManager entityManager;

	@Test
	@DisplayName("Decidir")
	void clientTestServiceSave() {

		ClientRecordDto dado = new ClientRecordDto("Teste0", "00000000001");
		this.createClient(dado);

		ClientModel savedClient = this.clientService.save(dado);

		Assertions.assertEquals(dado, savedClient);

	}

	private ClientModel createClient(ClientRecordDto client){
		ClientModel newClient = new ClientModel(client);
		BeanUtils.copyProperties(client, newClient);
		return newClient;
	}

}
