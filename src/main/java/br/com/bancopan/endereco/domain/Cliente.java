package br.com.bancopan.endereco.domain;

import java.time.LocalDate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

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
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENTE")
	@SequenceGenerator(name = "SEQ_CLIENTE", sequenceName = "SEQ_CLIENTE", allocationSize = 1)
	private Long codigo;
	
	@NotEmpty(message = "Nome é obrigatório")
	private String nome;
	
	@CPF
	private String cpf;
	
	@NotNull(message = "Data de nascimento é obrigatória")
	private LocalDate dataNascimento;
	
	private String profissao;
	
	@Embedded
	@NotNull(message="Endereço é obrigatório")
	private Endereco endereco;
	
    public static Cliente novoCliente(String nome, String cpf, LocalDate dataNascimento, String profissao,
            Endereco endereco) {
        return new Cliente(nome, cpf, dataNascimento, profissao, endereco);
    }

    public Cliente(String nome, String cpf, LocalDate dataNascimento, String profissao, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.profissao = profissao;
        this.endereco = endereco;
    }

}
