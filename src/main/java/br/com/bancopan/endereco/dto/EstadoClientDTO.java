package br.com.bancopan.endereco.dto;

import java.util.Arrays;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class EstadoClientDTO implements Comparable<EstadoClientDTO> {
    
    private static final List<String> SIGLAS_PRIORITARIAS_ORDENACAO = Arrays.asList("SP", "RJ");
    
    private Integer id;
    private String sigla;
    private String nome;
    
    @Override
    public int compareTo(EstadoClientDTO o) {
        
        for(String siglaPrioritaria : SIGLAS_PRIORITARIAS_ORDENACAO) {
            if(sigla.equals(siglaPrioritaria)) return -1;
            if(o.sigla.equals(siglaPrioritaria)) return 1;
        }

        return nome.compareTo(o.nome);
    }
}
