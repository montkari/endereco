package br.com.bancopan.endereco.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDTO {
	
	private Long codigo;
	
	private String nome;
	
	private String cpf;
	
	private LocalDate dataNascimento;
	
	private String profissao;
	
	private String cep;
	
	private String logradouro;	
	
	private String numero;	
	
	private String complemento;	
	
	private String referencia;
	
	private String bairro;	
	
	private String municipio;
	
	private String uf;

}
