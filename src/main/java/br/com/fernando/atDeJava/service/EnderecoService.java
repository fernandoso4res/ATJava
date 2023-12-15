package br.com.fernando.atDeJava.service;


import br.com.fernando.atDeJava.model.Cep;
import br.com.fernando.atDeJava.model.Pessoa;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class EnderecoService
{

    private List<Pessoa> pessoas = initPessoas();


    Logger logger = LoggerFactory.getLogger(EnderecoService.class);

    public List<Pessoa> initPessoas(){
        List<String> listaCepsApi = List.of("28930-000", "28660-000", "28500-000",
                "27998-000", "28180-000", "26650-000",
                "28960-000", "28250-000", "28570-000", "28300-000");
        for (int i = 0; i < listaCepsApi.size(); i++){
            Faker faker = new Faker();
            EnderecoService enderecoService= new EnderecoService();
            Cep cep = enderecoService.getByCode(listaCepsApi.get(i));
            String nomeCompleto = faker.name().fullName();
            Pessoa pessoa = Pessoa.builder().nome(nomeCompleto).id(i).cep(cep).build();
            pessoas.add(pessoa);
        }
        return pessoas;
    }
    public Cep getByCode(String cepCode){
        String uri = "https://brasilapi.com.br/api/cep/v1/" + cepCode;
        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI(uri))
                    .version(HttpClient.Version.HTTP_2)
                    .build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            Cep cep = objectMapper.readValue(response.body(), Cep.class);
            logger.info(cep.toString());
            return cep;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Pessoa> getAll(){
        return pessoas;
    }
}

