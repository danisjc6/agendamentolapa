package br.edu.ufape.agendamentolapa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "servidores")
@PrimaryKeyJoinColumn(name = "id")

public class Servidor extends Pessoa {
	
	@Column(unique = true, nullable = false)
    private String siape;
	
	@Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;

	public Servidor() {
        super();
    }

    public Servidor(String nome, String email, String cpf, String telefone,
                     String siape, Categoria categoria) {

        super(nome, email, cpf, telefone);
        this.siape = siape;
        this.categoria = categoria;
    }

	
    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public enum Categoria {
    	PROFESSOR,
    	TECNICO;
    }
    
    @Override
    public String toString() {
        return getNome();
    }
    
}