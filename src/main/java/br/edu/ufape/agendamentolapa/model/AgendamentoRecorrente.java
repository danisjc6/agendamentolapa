package br.edu.ufape.agendamentolapa.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "agendamentos_recorrentes")
public class AgendamentoRecorrente extends Agendamento {
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Frequencia frequencia;
	
	@Column(nullable = false)
	private LocalDate dataInicio;
	
	@Column(nullable = false)
	private LocalDate dataFim;
	
	public enum Frequencia {
	    DIARIA,
	    SEMANAL,
	    QUINZENAL,
	    MENSAL,
	    BIMESTRAL,
	    TRIMESTRAL,
	    SEMESTRAL,
	    ANUAL
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
}