package br.edu.ufape.agendamentoLapa.model;

public class Estudante extends Pessoa {
	private String curso;
	private String matricula;
	
	
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