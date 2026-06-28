package br.edu.ufape.agendamentoLapa.model;

import java.time.LocalDateTime;

public class AgendamentoRecorrente {
	private LocalDateTime diaSemana;
	private LocalDateTime mes;
	private String finalidade;
	private StatusAgendamentoRecorrente status;
	
	
	public LocalDateTime getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(LocalDateTime diaSemana) {
		this.diaSemana = diaSemana;
	}
	public LocalDateTime getMes() {
		return mes;
	}
	public void setMes(LocalDateTime mes) {
		this.mes = mes;
	}
	public String getFinalidade() {
		return finalidade;
	}
	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}
	public StatusAgendamentoRecorrente getStatus() {
		return status;
	}
	public void setStatus(StatusAgendamentoRecorrente status) {
		this.status = status;
	}
	
	public enum StatusAgendamentoRecorrente{
	    ATIVO,
	    CANCELADO,
	    FINALIZADO;
	}

	public void agendar() {
		//implementar
	}

	public void deletar() {
		//implementar
	}

	public void atualizar() {
		//implementar
	}

}