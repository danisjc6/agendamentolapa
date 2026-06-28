package br.edu.ufape.agendamentoLapa.model;

public class Servidor extends Pessoa {

    private String siape;
    private String categoria;

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public enum Categoria {
    	PROFESSOR,
    	TECNICO;
    }
}