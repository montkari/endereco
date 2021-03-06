package br.com.bancopan.endereco.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.bancopan.endereco.domain.Cliente;
import br.com.bancopan.endereco.dto.ClienteDTO;
import br.com.bancopan.endereco.exception.NotFoundException;
import br.com.bancopan.endereco.mapper.ClienteMapper;
import br.com.bancopan.endereco.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	@Autowired
	private ClienteMapper mapper;
	
	@Transactional(readOnly = true)
	public ClienteDTO buscarPorCpf(String cpf) {
		Cliente cliente = repository.findByCpf(cpf.replaceAll("\\D+", ""));
		
		if (Objects.isNull(cliente)) {
			throw new NotFoundException("Não encontrado cliente com o CPF " + cpf);
		}
		
		return mapper.toDto(cliente);
	}
	
	@Transactional
    public ClienteDTO cadastrar(ClienteDTO clienteDTO) {
    	Cliente novoCliente = mapper.toModel(clienteDTO);
    	novoCliente = repository.save(novoCliente);
        return mapper.toDto(novoCliente);
     }
	
	@Transactional
    public void alterarEndereco(String cpf, ClienteDTO clienteDTO) {
	    Cliente cliente = repository.findByCpf(cpf.replaceAll("\\D+", ""));
	    ClienteDTO dto = mapper.toDto(cliente);
	    
	    dto.setCep(clienteDTO.getCep());
	    dto.setLogradouro(clienteDTO.getLogradouro());
	    dto.setNumero(clienteDTO.getNumero());
	    dto.setComplemento(clienteDTO.getComplemento());
	    dto.setReferencia(clienteDTO.getReferencia());
	    dto.setBairro(clienteDTO.getBairro());
	    dto.setMunicipio(clienteDTO.getMunicipio());
	    dto.setUf(clienteDTO.getUf());
	    
	    Cliente clienteAlterado = mapper.toModel(dto);	    
	    repository.save(clienteAlterado);
     }

}
