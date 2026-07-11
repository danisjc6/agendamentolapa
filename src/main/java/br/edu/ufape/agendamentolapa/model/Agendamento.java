package br.edu.ufape.agendamentolapa.model;

import java.time.LocalTime;
import java.time.LocalDate;
import jakarta.persistence.*;


@Entity
@Table(name = "agendamentos")
public class Agendamento {
	private LocalTime horarioInicial;
	private LocalTime horarioFinal;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private String finalidade;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StatusAgendamento status;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Frequencia frequencia;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId (Long id) {
		this.id = id;
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

	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public Frequencia getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(Frequencia frequencia) {
		this.frequencia = frequencia;
	}

	public enum StatusAgendamento {
	    SOLICITADO,
	    APROVADO,
	    RECUSADO,
	    CANCELADO,
	    CONCLUIDO;
	}
	
	public enum Frequencia {
		UNICO,
		SEMANAL,
		QUINZENAL,
		MENSAL,
		SEMESTRAL;
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


public Pessoa getSolicitante() {
    return solicitante;
}

public void setSolicitante(Pessoa solicitante) {
    this.solicitante = solicitante;
}

public Sala getSala() {
    return sala;
}

public void setSala(Sala sala) {
    this.sala = sala;
}

public Servidor getAprovador() {
    return aprovador;
}

public void setAprovador(Servidor aprovador) {
    this.aprovador = aprovador;
}

// Construtor
public Agendamento() {
}

}
