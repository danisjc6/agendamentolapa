package br.edu.ufape.agendamentolapa.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pessoas")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome é obrigatório.")
	@Size(min = 3, max = 120)
	@Column(nullable = false)
	private String nome;
	
	@NotBlank(message = "O e-mail é obrigatório.")
	@Email(message = "E-mail inválido.")
	@Column(unique = true, nullable = false)
	private String email;
	
	@NotBlank(message = "O CPF é obrigatório.")
	@Column(unique = true, nullable = false)
	@Size(min = 11, max = 14)
	private String cpf;
	
	@NotBlank(message = "O telefone é obrigatório.")
	@Size(min = 10, max = 15)
	private String telefone;
	
	@JsonIgnore
	@OneToMany(mappedBy = "solicitante")
	private List<Agendamento> agendamentos;
	
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
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Pessoa)) return false;
	    Pessoa pessoa = (Pessoa) o;
	    return Objects.equals(id, pessoa.id);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(id);
	}
	
	@Override
	public String toString() {
	    return "Pessoa{" +
	            "id=" + id +
	            ", nome='" + nome + '\'' +
	            ", email='" + email + '\'' +
	            '}';
	}
}
