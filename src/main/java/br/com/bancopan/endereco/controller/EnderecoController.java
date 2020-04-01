package br.com.bancopan.endereco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bancopan.endereco.client.BuscaCepClient;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    
    @Autowired
    private BuscaCepClient buscaCepClient;
    
    @GetMapping("/{cep}")
    public String buscarCep(@PathVariable String cep) {
        return buscaCepClient.buscaEnderecoPorCEP(cep);
    }

}
