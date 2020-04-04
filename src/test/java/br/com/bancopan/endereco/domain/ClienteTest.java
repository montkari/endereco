package br.com.bancopan.endereco.domain;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.bancopan.endereco.dto.ClienteDTO;

public class ClienteTest {
    
    @Test
    public void erroCadastrarSemNome() {   
        
        ClienteDTO dtoCliente = new ClienteDTO();
        dtoCliente.setNome("");
        dtoCliente.setCpf("41689711043");
        dtoCliente.setDataNascimento(LocalDate.MIN);
        dtoCliente.setProfissao("Auxiliar de Escritório");
        dtoCliente.setCep("77060706");
        dtoCliente.setLogradouro("Rua dos Lírios");
        dtoCliente.setNumero("50");
        dtoCliente.setComplemento("Apartamento 2");
        dtoCliente.setReferencia("Próximo a escola Barcala");
        dtoCliente.setBairro("Setor Sônia Regina (Taquaralto)");
        dtoCliente.setMunicipio("Palmas");
        dtoCliente.setUf("TO");
        
        Assertions.assertThatThrownBy(dtoCliente::validate)
        .hasMessageContaining("Nome é obrigatório");
        
    }
    
    @Test
    public void erroCadastrarSemDataNascimento() {
       
        ClienteDTO dtoCliente = new ClienteDTO();
        dtoCliente.setNome("Joana");
        dtoCliente.setCpf("41689711043");
        dtoCliente.setDataNascimento(null);
        dtoCliente.setProfissao("Auxiliar de Escritório");
        dtoCliente.setCep("77060706");
        dtoCliente.setLogradouro("Rua dos Lírios");
        dtoCliente.setNumero("50");
        dtoCliente.setComplemento("Apartamento 2");
        dtoCliente.setReferencia("Próximo a escola Barcala");
        dtoCliente.setBairro("Setor Sônia Regina (Taquaralto)");
        dtoCliente.setMunicipio("Palmas");
        dtoCliente.setUf("TO");
        
        Assertions.assertThatThrownBy(dtoCliente::validate)
        .hasMessageContaining("Data de nascimento é obrigatória");
        
    }
    
    @Test
    public void erroCadastrarSemCep() {
        
        ClienteDTO dtoCliente = new ClienteDTO();
        dtoCliente.setNome("Joana");
        dtoCliente.setCpf("41689711043");
        dtoCliente.setDataNascimento(LocalDate.MIN);
        dtoCliente.setProfissao("Auxiliar de Escritório");
        dtoCliente.setCep("");
        dtoCliente.setLogradouro("Rua dos Lírios");
        dtoCliente.setNumero("50");
        dtoCliente.setComplemento("Apartamento 2");
        dtoCliente.setReferencia("Próximo a escola Barcala");
        dtoCliente.setBairro("Setor Sônia Regina (Taquaralto)");
        dtoCliente.setMunicipio("Palmas");
        dtoCliente.setUf("TO");
        
        Assertions.assertThatThrownBy(dtoCliente::validate)
        .hasMessageContaining("CEP é obrigatório");
        
    }
    
    @Test
    public void erroCadastrarSemLogradouro() {
        
        ClienteDTO dtoCliente = new ClienteDTO();
        dtoCliente.setNome("Joana");
        dtoCliente.setCpf("41689711043");
        dtoCliente.setDataNascimento(LocalDate.MIN);
        dtoCliente.setProfissao("Auxiliar de Escritório");
        dtoCliente.setCep("77060706");
        dtoCliente.setLogradouro("");
        dtoCliente.setNumero("50");
        dtoCliente.setComplemento("Apartamento 2");
        dtoCliente.setReferencia("Próximo a escola Barcala");
        dtoCliente.setBairro("Setor Sônia Regina (Taquaralto)");
        dtoCliente.setMunicipio("Palmas");
        dtoCliente.setUf("TO");
        
        Assertions.assertThatThrownBy(dtoCliente::validate)
        .hasMessageContaining("Logradouro é obrigatório");
        
    }
    
    @Test
    public void erroCadastrarSemBairro() {
        
        ClienteDTO dtoCliente = new ClienteDTO();
        dtoCliente.setNome("Joana");
        dtoCliente.setCpf("41689711043");
        dtoCliente.setDataNascimento(LocalDate.MIN);
        dtoCliente.setProfissao("Auxiliar de Escritório");
        dtoCliente.setCep("77060706");
        dtoCliente.setLogradouro("Rua dos Lírios");
        dtoCliente.setNumero("50");
        dtoCliente.setComplemento("Apartamento 2");
        dtoCliente.setReferencia("Próximo a escola Barcala");
        dtoCliente.setBairro("");
        dtoCliente.setMunicipio("Palmas");
        dtoCliente.setUf("TO");
        
        Assertions.assertThatThrownBy(dtoCliente::validate)
        .hasMessageContaining("Bairro é obrigatório");
        
    }
    
    @Test
    public void erroCadastrarSemMunicipio() {
        
        ClienteDTO dtoCliente = new ClienteDTO();
        dtoCliente.setNome("Joana");
        dtoCliente.setCpf("41689711043");
        dtoCliente.setDataNascimento(LocalDate.MIN);
        dtoCliente.setProfissao("Auxiliar de Escritório");
        dtoCliente.setCep("77060706");
        dtoCliente.setLogradouro("Rua dos Lírios");
        dtoCliente.setNumero("50");
        dtoCliente.setComplemento("Apartamento 2");
        dtoCliente.setReferencia("Próximo a escola Barcala");
        dtoCliente.setBairro("Setor Sônia Regina (Taquaralto)");
        dtoCliente.setMunicipio("");
        dtoCliente.setUf("TO");
        
        Assertions.assertThatThrownBy(dtoCliente::validate)
        .hasMessageContaining("Município é obrigatório");
        
    }
    
    @Test
    public void erroCadastrarSemUF() {
        
        ClienteDTO dtoCliente = new ClienteDTO();
        dtoCliente.setNome("Joana");
        dtoCliente.setCpf("41689711043");
        dtoCliente.setDataNascimento(LocalDate.MIN);
        dtoCliente.setProfissao("Auxiliar de Escritório");
        dtoCliente.setCep("77060706");
        dtoCliente.setLogradouro("Rua dos Lírios");
        dtoCliente.setNumero("50");
        dtoCliente.setComplemento("Apartamento 2");
        dtoCliente.setReferencia("Próximo a escola Barcala");
        dtoCliente.setBairro("Setor Sônia Regina (Taquaralto)");
        dtoCliente.setMunicipio("Palmas");
        dtoCliente.setUf("");
        
        Assertions.assertThatThrownBy(dtoCliente::validate)
        .hasMessageContaining("UF é obrigatório");
        
    }

}
