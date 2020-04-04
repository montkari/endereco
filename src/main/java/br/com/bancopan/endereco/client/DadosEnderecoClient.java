package br.com.bancopan.endereco.client;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.bancopan.endereco.dto.CepClientDTO;
import br.com.bancopan.endereco.dto.EstadoClientDTO;
import br.com.bancopan.endereco.dto.MunicipioClientDTO;
import br.com.bancopan.endereco.exception.NotFoundException;

@Service
public class DadosEnderecoClient {

    @Value("${url.consulta.cep}")
    private String urlCep;

    @Value("${url.consulta.estados}")
    private String urlEstados;

    public CepClientDTO buscaEnderecoPorCEP(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForEntity(urlCep + cep + "/json", CepClientDTO.class).getBody();
        } catch (HttpClientErrorException e) {
            throw new NotFoundException("CEP não encontrado");
        }
    }

    public List<EstadoClientDTO> buscaEstados() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<EstadoClientDTO[]> responseEntity = restTemplate
                    .getForEntity(urlEstados, EstadoClientDTO[].class);
            
            List<EstadoClientDTO> response = Arrays.asList(responseEntity.getBody());
            Collections.sort(response);        
            return response;
        } catch (HttpClientErrorException e) {
            throw new Exception("Erro ao buscar dados");
        }
    }
    
    public ResponseEntity<MunicipioClientDTO[]> buscaMunicipios(Integer idEstado) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForEntity(urlEstados + idEstado + "/municipios", MunicipioClientDTO[].class);
        } catch (HttpClientErrorException e) {
            throw new Exception("Erro ao buscar dados");
        }
    }
}
