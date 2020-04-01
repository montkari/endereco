package br.com.bancopan.endereco.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.bancopan.endereco.domain.Cliente;
import br.com.bancopan.endereco.dto.ClienteDTO;


@Component
public class ClienteMapper {

	public List<ClienteDTO> mapearListDto(List<Cliente> lsCliente){
		List<ClienteDTO> lsClienteDto = new ArrayList<ClienteDTO>();
		for(Cliente cliente : lsCliente) {
			lsClienteDto.add(mapear(cliente));
		}
		return lsClienteDto;
	}
	
	public Cliente mapearAlteracao(ClienteDTO dto) {
		Cliente usuario = new Cliente();

		usuario.setCpf(dto.getCpf());
		usuario.setLogin(dto.getLogin());
		usuario.setPalavraSeguranca(dto.getPalavraSeguranca());
		usuario.setSenha(dto.getSenha());
		usuario.setDtUpdate(LocalDate.now());
		return usuario;
	}

	public Usuario mapearCriacao(UsuarioDto dto) {
		Usuario usuario = new Usuario();

		usuario.setCpf(dto.getCpf());
		usuario.setLogin(dto.getLogin());
		usuario.setPalavraSeguranca(dto.getPalavraSeguranca());
		usuario.setSenha(dto.getSenha());
		usuario.setDtCreate(LocalDate.now());
		return usuario;
	}

	public UsuarioDto mapear(Usuario usuario) {
		UsuarioDto dto = new UsuarioDto();

		dto.setCpf(usuario.getCpf());
		dto.setLogin(usuario.getLogin());
		dto.setPalavraSeguranca(usuario.getPalavraSeguranca());
		dto.setSenha(usuario.getSenha());
		return dto;
	}

}
