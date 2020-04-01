package br.com.bancopan.endereco.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bancopan.endereco.domain.Cliente;
import br.com.bancopan.endereco.dto.ClienteDTO;
import br.com.bancopan.endereco.exception.ClienteNaoEncontradoException;
import br.com.bancopan.endereco.mapper.ClienteMapper;
import br.com.bancopan.endereco.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	@Autowired
	private ClienteMapper mapper;
	
	public ClienteDTO buscarPorCpf(String cpf) {
		Cliente cliente = repository.findByCpf(cpf);
		
		if (Objects.isNull(cliente)) {
			throw new ClienteNaoEncontradoException("Não encontrado cliente com o CPF " + cpf);
		}
		
		return mapper.toDto(cliente);
	}
	
    public ClienteDTO cadastrar(ClienteDTO clienteDTO) {
    	Cliente novoCliente = mapper.toEntity(clienteDTO);
        return mapper.toDto(repository.save(novoCliente));
     }

}
