package br.com.bancopan.endereco.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	
	private String cep;
	
	private String logradouro;
	
	private String numero;
	
	private String complemento;
	
	private String referencia;
	
	private String bairro;
	
	private String municipio;
	
	private String uf;

}
