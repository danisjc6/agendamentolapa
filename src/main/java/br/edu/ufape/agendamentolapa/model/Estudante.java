package br.edu.ufape.agendamentolapa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estudantes")
@PrimaryKeyJoinColumn(name = "id")

public class Estudante extends Pessoa {
	
	@Column(nullable = false)
	private String curso;
	
	@Column(unique = true, nullable = false)
	private String matricula;
	
	public Estudante() {
        super();
    }

    public Estudante(String nome, String email, String cpf, String telefone,
                     String curso, String matricula) {

        super(nome, email, cpf, telefone);

        this.curso = curso;
        this.matricula = matricula;
    }
	
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}