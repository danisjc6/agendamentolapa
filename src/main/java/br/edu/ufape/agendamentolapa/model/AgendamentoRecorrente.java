package br.edu.ufape.agendamentolapa.model;

import java.time.LocalDate;

import jakarta.persistence.*;

public class AgendamentoRecorrente extends Agendamento{
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Frequencia frequencia;
	
	@Column(nullable = false)
	private LocalDate dataInicio;
	
	@Column(nullable = false)
	private LocalDate dataFim;
	
	public enum Frequencia {
		SEMANAL,
		QUINZENAL,
		MENSAL
	}
	
	public AgendamentoRecorrente() {
        super();
    }
	
	public Frequencia getFrequencia() {
	    return frequencia;
	}

	public void setFrequencia(Frequencia frequencia) {
	    this.frequencia = frequencia;
	}
}