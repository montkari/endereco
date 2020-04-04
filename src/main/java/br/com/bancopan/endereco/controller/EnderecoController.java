package br.com.bancopan.endereco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bancopan.endereco.client.DadosEnderecoClient;
import br.com.bancopan.endereco.dto.CepClientDTO;
import br.com.bancopan.endereco.dto.EstadoClientDTO;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    
    @Autowired
    private DadosEnderecoClient dadosEnderecoClient;
    
    @GetMapping("/{cep}")
    public CepClientDTO buscarCep(@PathVariable String cep) {
        return dadosEnderecoClient.buscaEnderecoPorCEP(cep);
    }
    
    @GetMapping("/estados")
    public List<EstadoClientDTO> buscarEstados() throws Exception {
        return dadosEnderecoClient.buscaEstados();
    }
    
    @GetMapping("/{idEstado}/municipios")
    public ResponseEntity<Object[]> buscarMunicipios(@PathVariable Integer idEstado) throws Exception {
        return dadosEnderecoClient.buscaMunicipios(idEstado);
    }

}
