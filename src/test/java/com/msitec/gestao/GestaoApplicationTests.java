package com.msitec.gestao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.msitec.gestao.models.ClientModel;
import com.msitec.gestao.services.ClientService;

@SpringBootTest
class GestaoApplicationTests {

	static final ClientModel CLIENT_0 = new ClientModel(1L, "Lucas", "09955411910");
	static final ClientModel CLIENT_1 = new ClientModel(2L, "Maria", "09955411911");
	static final ClientModel CLIENT_2 = new ClientModel(3L, "João", "09955411912");


	@Autowired
	ClientService clientService;

	@Test
	void testListClientsPaginated() {
		// Pageable pageable = PageRequest.of(0, 2);
		// Page<ClientModel> pageClients =  clientService.listClients(pageable);

		// assertEquals(2, pageClients.getContent().size());
		// assertEquals(CLIENT_0, pageClients.getContent().get(0));
		// assertEquals(CLIENT_1, pageClients.getContent().get(1));
	}

}
