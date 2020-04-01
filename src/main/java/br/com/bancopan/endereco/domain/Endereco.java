package br.com.bancopan.endereco.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

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
