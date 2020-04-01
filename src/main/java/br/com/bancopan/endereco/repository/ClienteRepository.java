package br.com.bancopan.endereco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bancopan.endereco.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	public Cliente findByCpf(String cpf);

}
