package br.com.bancopan.endereco.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDTO {
	
	private Long codigo;
	
	@NotEmpty(message = "Nome é obrigatório")
	private String nome;
	
	@CPF
	private String cpf;
	
	//@NotEmpty(message = "Data de nascimento é obrigatória")
	private LocalDate dataNascimento;
	
	private String profissao;
	
	@NotEmpty(message = "CEP é obrigatório")
	private String cep;
	
	@NotEmpty(message = "Logradouro é obrigatório")
	private String logradouro;	
	
	private String numero;	
	
	private String complemento;	
	
	private String referencia;
	
	@NotEmpty(message = "Bairro é obrigatório")
	private String bairro;	
	
	@NotEmpty(message = "Município é obrigatório")
	private String municipio;
	
	@NotEmpty(message = "UF é obrigatório")
	private String uf;

}
