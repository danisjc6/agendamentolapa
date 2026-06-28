package br.edu.ufape.agendamentoLapa.model;

import java.time.LocalDateTime;

	public class Agendamento {
		private LocalDateTime data;
		private LocalDateTime horarioInicial;
		private LocalDateTime horarioFinal;
		private String finalidade;
		private StatusAgendamento status;
		

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public LocalDateTime getHorarioInicial() {
		return horarioInicial;
	}

	public void setHorarioInicial(LocalDateTime horarioInicial) {
		this.horarioInicial = horarioInicial;
	}

	public LocalDateTime getHorarioFinal() {
		return horarioFinal;
	}

	public void setHorarioFinal(LocalDateTime horarioFinal) {
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

	public enum StatusAgendamento{
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
