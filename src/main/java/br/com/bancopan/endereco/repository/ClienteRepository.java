package br.com.bancopan.endereco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bancopan.endereco.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	public Cliente findByCpf(String cpf);

}
