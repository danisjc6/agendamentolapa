package br.edu.ufape.agendamentolapa.model;

import java.time.LocalTime;

import jakarta.persistence.*;

import java.time.LocalDate;

	public class Agendamento {
		private LocalDate data;
		private LocalTime horarioInicial;
		private LocalTime horarioFinal;
		private String finalidade;
		private StatusAgendamento status;
		

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHorarioInicial() {
		return horarioInicial;
	}

	public void setHorarioInicial(LocalTime horarioInicial) {
		this.horarioInicial = horarioInicial;
	}

	public LocalTime getHorarioFinal() {
		return horarioFinal;
	}

	public void setHorarioFinal(LocalTime horarioFinal) {
		this.horarioFinal = horarioFinal;
	}

	public String getFinalidade() {
		return finalidade;
	}

	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}

	public StatusAgendamento getStatus() {
		return status;
	}

	public void setStatus(StatusAgendamento status) {
	    this.status = status;
	}

	public enum StatusAgendamento {
	    SOLICITADO,
	    APROVADO,
	    RECUSADO,
	    CANCELADO,
	    CONCLUIDO
	}
// Relacionamento agendamento-pessoa
	@ManyToOne(optional = false)
	@JoinColumn(name = "solicitante_id", nullable = false)
	private Pessoa solicitante;
	
	
// Relacionamento agendamento-sala	
	@ManyToOne(optional = false)
	@JoinColumn(name = "sala_id", nullable = false)
	private Sala sala;

	
// Relacionamento servidor-aprovador
	@ManyToOne
	@JoinColumn(name = "aprovador_id")
	private Servidor aprovador;
}
