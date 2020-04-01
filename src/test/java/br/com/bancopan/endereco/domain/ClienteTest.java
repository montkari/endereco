package br.com.bancopan.endereco.domain;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.bancopan.endereco.fixture.EnderecoFixture;

public class ClienteTest {
    
    @Test
    public void cadastraCliente() {
        Assertions.assertThatCode(() -> 
            Cliente.novoCliente("Alice", "41689711043", LocalDate.MIN, "Auxiliar de Escritório", 
                    EnderecoFixture.enderecoCompleto()))
            .doesNotThrowAnyException();
    }
    
    @Test
    public void erroCadastrarClienteSemNome() {
        Cliente novoCliente = Cliente.novoCliente("", "41689711043", LocalDate.MIN, "Auxiliar de Escritório", 
                EnderecoFixture.enderecoCompleto());
        
        Assertions.assertThatThrownBy(() -> novoCliente.validate(CadastroGroup.class))
        .hasMessageContaining("Nome é obrigatório");
    }

}
