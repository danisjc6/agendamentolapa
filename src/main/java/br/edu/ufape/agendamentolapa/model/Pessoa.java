package br.edu.ufape.agendamentolapa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "pessoas")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome é obrigatório.")
	private String nome;
	
	@NotBlank(message = "O e-mail é obrigatório.")
	@Email(message = "E-mail inválido.")
	@Column(unique = true, nullable = false)
	private String email;
	
	@NotBlank(message = "O CPF é obrigatório.")
	@Column(unique = true, nullable = false)
	private String cpf;
	
	@NotBlank(message = "O telefone é obrigatório.")
	private String telefone;
	
	
	
	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public Pessoa() {
	}
	
	
	public Pessoa(String nome, String email, String cpf, String telefone) {
	    this.nome = nome;
	    this.email = email;
	    this.cpf = cpf;
	    this.telefone = telefone;
	}
}
