package br.edu.ufape.agendamentolapa.dto;

import jakarta.validation.constraints.NotBlank;

public class EstudanteDTO extends PessoaDTO {

    @NotBlank(message = "O curso é obrigatório.")
    private String curso;

    @NotBlank(message = "A matrícula é obrigatória.")
    private String matricula;

    public EstudanteDTO() {
    }

    public EstudanteDTO(String nome,
                        String email,
                        String cpf,
                        String telefone,
                        String curso,
                        String matricula) {

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