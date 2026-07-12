package br.edu.ufape.agendamentolapa.mapper;

import br.edu.ufape.agendamentolapa.dto.ServidorDTO;
import br.edu.ufape.agendamentolapa.model.Servidor;

public class ServidorMapper extends PessoaMapper {

    public Servidor toEntity(ServidorDTO dto) {

        Servidor servidor = new Servidor();

        super.toEntity(dto, servidor);

        servidor.setSiape(dto.getSiape());
        servidor.setCategoria(dto.getCategoria());

        return servidor;
    }
}