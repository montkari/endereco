package br.com.bancopan.endereco.fixture;

import br.com.bancopan.endereco.domain.Endereco;

public class EnderecoFixture {
    
    public static Endereco enderecoCompleto() {
        return Endereco.novoEndereco("77060706", "Rua dos Lírios", "50", "Apartamento 2", 
                "Próximo a escola Barcala", "Setor Sônia Regina (Taquaralto)", "Palmas", "TO");
    }

}
