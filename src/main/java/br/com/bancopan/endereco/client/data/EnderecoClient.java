package br.com.bancopan.endereco.client.data;

import lombok.Data;

@Data
public class EnderecoClient {
    
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;

}
