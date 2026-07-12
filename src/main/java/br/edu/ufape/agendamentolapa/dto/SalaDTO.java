package br.edu.ufape.agendamentolapa.dto;

import br.edu.ufape.agendamentolapa.model.Sala;

public class SalaDTO {

    private Long id;
    private String nomeSala;
    private int capacidade;
    private Sala.Tipo tipo;

    public SalaDTO() {
    }

    public SalaDTO(Sala sala) {
        this.id = sala.getId();
        this.nomeSala = sala.getNomeSala();
        this.capacidade = sala.getCapacidade();
        this.tipo = sala.getTipo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Sala.Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Sala.Tipo tipo) {
        this.tipo = tipo;
    }
}