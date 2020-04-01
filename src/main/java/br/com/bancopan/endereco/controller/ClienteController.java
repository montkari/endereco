package br.com.bancopan.endereco.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.bancopan.endereco.dto.ClienteDTO;
import br.com.bancopan.endereco.service.ClienteService;

@Controller
@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/{cpf}")
	public ClienteDTO buscarPorCpf(@PathVariable String cpf) {
		return clienteService.buscarPorCpf(cpf);
	}
	
	@PostMapping
    public ResponseEntity<?> cadastrar(@Valid @RequestBody ClienteDTO dto) {
        ClienteDTO novoCliente = clienteService.cadastrar(dto);
        
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(novoCliente.getCodigo()).toUri();
       return ResponseEntity.created(location).build();
    }

}
