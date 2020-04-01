package br.com.bancopan.endereco.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.bancopan.endereco.exception.NotFoundException;

@Component
public class DadosEnderecoClient {

    @Value("${url.consulta.cep}")
    private String urlCep;

    @Value("${url.consulta.estados}")
    private String urlEstados;

    public ResponseEntity<String> buscaEnderecoPorCEP(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForEntity(urlCep + cep + "/json", String.class);
        } catch (HttpClientErrorException e) {
            throw new NotFoundException("CEP não encontrado");
        }
    }

    public ResponseEntity<Object[]> buscaEstados() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForEntity(urlEstados, Object[].class);
        } catch (HttpClientErrorException e) {
            throw new Exception("Erro ao buscar dados");
        }
    }
}
