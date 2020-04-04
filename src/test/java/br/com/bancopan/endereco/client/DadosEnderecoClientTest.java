package br.com.bancopan.endereco.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Objects;

import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.bancopan.endereco.EnderecoApplicationTests;
import br.com.bancopan.endereco.dto.CepClientDTO;

@TestInstance(Lifecycle.PER_CLASS)
public class DadosEnderecoClientTest extends EnderecoApplicationTests {
    
    @MockBean
    private DadosEnderecoClient dadosEnderecoCliente;
    

    @Test
    public void testBuscaCep() throws Exception {
        
        CepClientDTO resultadoEsperado = getResultadoCep();      
        when(dadosEnderecoCliente.buscaEnderecoPorCEP("06390448")).thenReturn(resultadoEsperado);
        
        CepClientDTO cepClienteDTO = dadosEnderecoCliente.buscaEnderecoPorCEP("06390448");
        assertThat(Objects.equals(cepClienteDTO.getCep(), resultadoEsperado.getCep()));
    }
    
    public CepClientDTO getResultadoCep() {
        CepClientDTO cepDTO = new CepClientDTO();
        cepDTO.setCep("06390-448");
        cepDTO.setLogradouro("Rua Flor de Maio");
        cepDTO.setComplemento("");
        cepDTO.setBairro("Conjunto Habitacional 120 Casas");
        cepDTO.setLocalidade("Carapicuíba");
        cepDTO.setUf("SP");
        return cepDTO;
    }

}
