package br.edu.ufape.agendamentolapa.dto;

import br.edu.ufape.agendamentolapa.model.Servidor.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ServidorDTO extends PessoaDTO {

    @NotBlank(message = "O SIAPE é obrigatório.")
    private String siape;

    @NotNull(message = "A categoria é obrigatória.")
    private Categoria categoria;

    public ServidorDTO() {
    }

    public ServidorDTO(String nome,
                       String email,
                       String cpf,
                       String telefone,
                       String siape,
                       Categoria categoria) {

        super(nome, email, cpf, telefone);

        this.siape = siape;
        this.categoria = categoria;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}