package br.edu.ufape.agendamentoLapa.model;

public class Sala {
	private String nomeSala;
	private int capacidade;
	private String tipo;
	
	
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public enum Tipo {
		REUNIAO,
		LABORATORIO,
		AUDITORIO,
		MUSEU;
	}
}