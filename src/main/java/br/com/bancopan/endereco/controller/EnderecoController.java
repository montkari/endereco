package br.com.bancopan.endereco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bancopan.endereco.client.DadosEnderecoClient;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    
    @Autowired
    private DadosEnderecoClient dadosEnderecoClient;
    
    @GetMapping("/{cep}")
    public ResponseEntity<String> buscarCep(@PathVariable String cep) {
        return dadosEnderecoClient.buscaEnderecoPorCEP(cep);
    }
    
    @GetMapping("/estados")
    public ResponseEntity<Object[]> buscarEstados() throws Exception {
        return dadosEnderecoClient.buscaEstados();
    }

}
