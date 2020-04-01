package br.com.bancopan.endereco.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.bancopan.endereco.exception.NotFoundException;


@Component
public class BuscaCepClient {
    
    @Value("${url.consulta.cep}")
    private String urlConsulta;
 
    public String buscaEnderecoPorCEP(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        try {
          ResponseEntity<String> response = restTemplate.getForEntity(urlConsulta + cep + "/json", String.class);
          return response.getBody();
        } catch (HttpClientErrorException e ) {
            throw new NotFoundException("CEP não encontrado");
        }
    }

}
