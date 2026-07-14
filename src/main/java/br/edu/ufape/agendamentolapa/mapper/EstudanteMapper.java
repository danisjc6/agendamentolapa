package br.edu.ufape.agendamentolapa.mapper;

import br.edu.ufape.agendamentolapa.dto.EstudanteDTO;
import br.edu.ufape.agendamentolapa.model.Estudante;

public class EstudanteMapper {

    public static EstudanteDTO toDTO(Estudante estudante) {

        if (estudante == null)
            return null;

        EstudanteDTO dto = new EstudanteDTO();

        PessoaMapper.preencherPessoaDTO(estudante, dto);

        dto.setCurso(estudante.getCurso());
        dto.setMatricula(estudante.getMatricula());

        return dto;
    }

    public static Estudante toEntity(EstudanteDTO dto) {

        if (dto == null)
            return null;

        Estudante estudante = new Estudante();

        PessoaMapper.preencherPessoa(dto, estudante);

        estudante.setCurso(dto.getCurso());
        estudante.setMatricula(dto.getMatricula());

        return estudante;
    }
}