package br.edu.ufape.agendamentolapa.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import br.edu.ufape.agendamentolapa.model.Agendamento.Frequencia;
import br.edu.ufape.agendamentolapa.model.Agendamento.StatusAgendamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AgendamentoDTO {

    private Long id;

    @NotNull(message = "A data inicial é obrigatória.")
    private LocalDate dataInicio;

    @NotNull(message = "A data final é obrigatória.")
    private LocalDate dataFim;

    @NotNull(message = "O horário inicial é obrigatório.")
    private LocalTime horarioInicial;

    @NotNull(message = "O horário final é obrigatório.")
    private LocalTime horarioFinal;

    @NotBlank(message = "A finalidade é obrigatória.")
    private String finalidade;

    @NotNull(message = "A frequência é obrigatória.")
    private Frequencia frequencia;

    private StatusAgendamento status;

    @NotNull(message = "O solicitante é obrigatório.")
    private Long solicitanteId;

    @NotNull(message = "A sala é obrigatória.")
    private Long salaId;

    // Opcional: será preenchido quando um servidor aprovar o agendamento
    private Long aprovadorId;

    public AgendamentoDTO() {
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Frequencia getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Frequencia frequencia) {
        this.frequencia = frequencia;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }

    public Long getSolicitanteId() {
        return solicitanteId;
    }

    public void setSolicitanteId(Long solicitanteId) {
        this.solicitanteId = solicitanteId;
    }

    public Long getSalaId() {
        return salaId;
    }

    public void setSalaId(Long salaId) {
        this.salaId = salaId;
    }

    public Long getAprovadorId() {
        return aprovadorId;
    }

    public void setAprovadorId(Long aprovadorId) {
        this.aprovadorId = aprovadorId;
    }
}