package br.edu.ufape.agendamentolapa.mapper;

import br.edu.ufape.agendamentolapa.dto.PessoaDTO;
import br.edu.ufape.agendamentolapa.model.Pessoa;

public final class PessoaMapper {

    private PessoaMapper() {
    }

    public static void preencherPessoaDTO(Pessoa pessoa, PessoaDTO dto) {

        dto.setId(pessoa.getId());
        dto.setNome(pessoa.getNome());
        dto.setEmail(pessoa.getEmail());
        dto.setCpf(pessoa.getCpf());
        dto.setTelefone(pessoa.getTelefone());
    }

    public static void preencherPessoa(PessoaDTO dto, Pessoa pessoa) {

        pessoa.setId(dto.getId());
        pessoa.setNome(dto.getNome());
        pessoa.setEmail(dto.getEmail());
        pessoa.setCpf(dto.getCpf());
        pessoa.setTelefone(dto.getTelefone());
    }
}