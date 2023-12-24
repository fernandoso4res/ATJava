package br.com.fernando.atDeJava.ExternalAPI;

import br.com.fernando.atDeJava.model.Cep;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CepUtil {
    Logger logger = LoggerFactory.getLogger(CepUtil.class);
    public Cep getByCep(String cepId){
        String uri = "https://viacep.com.br/ws/" +cepId+ "/json/";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI(uri))
                    .version(HttpClient.Version.HTTP_2)
                    .build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            Cep cep = objectMapper.readValue(response.body(), Cep.class);
            if (response.statusCode() == 200){
                String statusCodeResponse = response.statusCode() + "";
                logger.info("Status Code: " + statusCodeResponse + " OK");
            }
            return cep;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

