package br.com.bancopan.endereco.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.bancopan.endereco.EnderecoApplicationTests;

@TestInstance(Lifecycle.PER_CLASS)
public class ClienteControllerTest extends EnderecoApplicationTests  {
    
    private MockMvc mockMvc;
    
    @Autowired
    private ClienteController clienteController;
    
    @BeforeAll
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
    }
    
    @Test
    public void testBuscarPorCpf() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/cliente/14741622070")).andExpect(MockMvcResultMatchers.status().isOk());
    }

}
