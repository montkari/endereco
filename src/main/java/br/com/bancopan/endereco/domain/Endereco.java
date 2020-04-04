package br.com.bancopan.endereco.domain;

import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Endereco {
	
	private String cep;
	
	private String logradouro;
	
	private String numero;
	
	private String complemento;
	
	private String referencia;
	
	private String bairro;
	
	private String municipio;
	
	private String uf;
	
	public static Endereco novoEndereco(String cep, String logradouro, String numero, String complemento,
	        String referencia, String bairro, String municipio, String uf) {
	    return new Endereco(cep, logradouro, numero, complemento, referencia, bairro, municipio, uf);
	}
	
	private Endereco(String cep, String logradouro, String numero, String complemento,
            String referencia, String bairro, String municipio, String uf) {
	    this.cep = cep;
	    this.logradouro = logradouro;
	    this.numero = numero;
	    this.complemento = complemento;
	    this.referencia = referencia;
	    this.bairro = bairro;
	    this.municipio = municipio;
	    this.uf = uf;
	}
	

}
