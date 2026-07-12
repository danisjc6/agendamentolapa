package br.edu.ufape.agendamentolapa.mapper;

import br.edu.ufape.agendamentolapa.dto.PessoaDTO;
import br.edu.ufape.agendamentolapa.model.Pessoa;

public class PessoaMapper {

    protected void toEntity(PessoaDTO dto, Pessoa pessoa) {
        pessoa.setNome(dto.getNome());
        pessoa.setEmail(dto.getEmail());
        pessoa.setCpf(dto.getCpf());
        pessoa.setTelefone(dto.getTelefone());
    }

    protected void toDTO(Pessoa pessoa, PessoaDTO dto) {
        dto.setId(pessoa.getId());
        dto.setNome(pessoa.getNome());
        dto.setEmail(pessoa.getEmail());
        dto.setCpf(pessoa.getCpf());
        dto.setTelefone(pessoa.getTelefone());
    }
}