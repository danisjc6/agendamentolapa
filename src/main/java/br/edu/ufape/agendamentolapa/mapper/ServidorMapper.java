package br.edu.ufape.agendamentolapa.mapper;

import br.edu.ufape.agendamentolapa.dto.ServidorDTO;
import br.edu.ufape.agendamentolapa.model.Servidor;

public class ServidorMapper {

    public static ServidorDTO toDTO(Servidor servidor) {

        if (servidor == null)
            return null;

        ServidorDTO dto = new ServidorDTO();

        PessoaMapper.preencherPessoaDTO(servidor, dto);

        dto.setSiape(servidor.getSiape());
        dto.setCategoria(servidor.getCategoria());

        return dto;
    }

    public static Servidor toEntity(ServidorDTO dto) {

        if (dto == null)
            return null;

        Servidor servidor = new Servidor();

        PessoaMapper.preencherPessoa(dto, servidor);

        servidor.setSiape(dto.getSiape());
        servidor.setCategoria(dto.getCategoria());

        return servidor;
    }
}