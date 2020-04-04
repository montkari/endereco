package br.com.bancopan.endereco.domain;

import java.time.LocalDate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.bancopan.endereco.dto.validation.DTOValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "TB_CLIENTE")
@Getter
@Setter
public class Cliente extends DTOValidation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENTE")
	@SequenceGenerator(name = "SEQ_CLIENTE", sequenceName = "SEQ_CLIENTE", allocationSize = 1)
	private Long codigo;
	
	private String nome;
	
	private String cpf;
	
	private LocalDate dataNascimento;
	
	private String profissao;
	
	@Embedded
	private Endereco endereco;
	
    public void alterarEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
