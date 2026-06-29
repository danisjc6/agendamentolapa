package br.edu.ufape.agendamentolapa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "salas")

public class Sala {
	private Long id;
	private String nomeSala;
	private int capacidade;
	private Tipo tipo;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	public String getNomeSala() {
		return nomeSala;
	}
	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public enum Tipo {
		REUNIAO,
		LABORATORIO,
		AUDITORIO,
		MUSEU;
	}
	
	public Sala() {
	}
	
	
}