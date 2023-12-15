package br.com.fernando.atDeJava;

import br.com.fernando.atDeJava.model.Cep;
import br.com.fernando.atDeJava.service.EnderecoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnderecoServiceTest {
    Logger logger = LoggerFactory.getLogger(EnderecoServiceTest.class);

    @Test
    @DisplayName("Deve retornar o endereco de acordo com o CEP")
    public void testePeloCodigo() {
        EnderecoService enderecoService = new EnderecoService();
        Cep cep = enderecoService.getByCode("95150000");
        logger.info(cep.toString());
        assertEquals("Nova Petrópolis", cep.getCity());
    }
}