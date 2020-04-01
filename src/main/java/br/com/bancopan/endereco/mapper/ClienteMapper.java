package br.com.bancopan.endereco.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.bancopan.endereco.domain.Cliente;
import br.com.bancopan.endereco.domain.Endereco;
import br.com.bancopan.endereco.dto.ClienteDTO;


@Component
public class ClienteMapper {

	public List<ClienteDTO> toListDto(List<Cliente> lsCliente){
		List<ClienteDTO> lsClienteDto = new ArrayList<ClienteDTO>();
		for(Cliente cliente : lsCliente) {
			lsClienteDto.add(toDto(cliente));
		}
		return lsClienteDto;
	}
	
	public Cliente toModel(ClienteDTO dto) {
		Cliente cliente = new Cliente();
		
		cliente.setCodigo(dto.getCodigo());
		cliente.setNome(dto.getNome());
		cliente.setCpf(dto.getCpf() != null ? dto.getCpf().replaceAll("\\D+", "") : null);
		cliente.setDataNascimento(dto.getDataNascimento());
		cliente.setProfissao(dto.getProfissao());
		cliente.setEndereco(Endereco.novoEndereco(dto.getCep(), dto.getLogradouro(), 
		        dto.getNumero(), dto.getComplemento(), dto.getReferencia(), dto.getBairro(), 
		        dto.getMunicipio(), dto.getUf()));

		return cliente;
	}

	public ClienteDTO toDto(Cliente cliente) {
	    ClienteDTO dto = new ClienteDTO();
	    
	    dto.setCodigo(cliente.getCodigo());
	    dto.setNome(cliente.getNome());
	    dto.setCpf(cliente.getCpf() != null ? cliente.getCpf().replaceAll("\\D+", "") : null);
	    dto.setDataNascimento(cliente.getDataNascimento());
	    dto.setProfissao(cliente.getProfissao());
	    dto.setCep(cliente.getEndereco().getCep());
	    dto.setLogradouro(cliente.getEndereco().getLogradouro());
	    dto.setNumero(cliente.getEndereco().getNumero());
	    dto.setComplemento(cliente.getEndereco().getComplemento());
	    dto.setReferencia(cliente.getEndereco().getReferencia());
	    dto.setBairro(cliente.getEndereco().getBairro());
	    dto.setMunicipio(cliente.getEndereco().getMunicipio());
	    dto.setUf(cliente.getEndereco().getUf());
		return dto;
	}

}
