package br.com.fernando.atDeJava;

import br.com.fernando.atDeJava.model.Cliente;
import br.com.fernando.atDeJava.service.ClienteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ClienteServiceTest {
    Logger logger = LoggerFactory.getLogger(ClienteServiceTest.class);

    @Autowired
    ClienteService clienteService;
    @Test
    @DisplayName("Verifica se o cliente está nulo")
    public void testaPeloId(){
        int id = 1;
        Cliente cliente = clienteService.getById(id);
        assertNotNull(cliente);

    }
}
