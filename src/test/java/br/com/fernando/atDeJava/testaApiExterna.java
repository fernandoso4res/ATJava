package br.com.fernando.atDeJava;

import br.com.fernando.atDeJava.ExternalAPI.CepUtil;
import br.com.fernando.atDeJava.model.Cep;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class testaApiExterna {
    Logger logger = LoggerFactory.getLogger(testaApiExterna.class);
    @Test
    @DisplayName("Testa se o nome da cidade é retornado corretamente")
    public void testaLocalidadeApiExterna(){
        CepUtil cepUtil = new CepUtil();
        Cep testeCep = cepUtil.getByCep("95150000");
        assertEquals("Nova Petrópolis", testeCep.getLocalidade());
    }

    @Test
    @DisplayName("Verifica se o CEP existe na API")
    public void testaCepInexistente(){
        CepUtil cepUtil = new CepUtil();
        assertThrows(RuntimeException.class, () ->{
            cepUtil.getByCep("57599999");
        });
    }
}
