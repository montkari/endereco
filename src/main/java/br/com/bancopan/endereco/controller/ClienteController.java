package br.com.bancopan.endereco.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bancopan.endereco.dto.ClienteDTO;
import br.com.bancopan.endereco.service.ClienteService;

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
       clienteService.cadastrar(dto);
       return ResponseEntity.ok().build();
    }
	
	@PutMapping("/endereco/{cpf}")
    public ResponseEntity<?> alterarEndereco(@PathVariable String cpf, @RequestBody ClienteDTO dto) {
       clienteService.alterarEndereco(cpf, dto);
       return ResponseEntity.ok().build();
    }
}
