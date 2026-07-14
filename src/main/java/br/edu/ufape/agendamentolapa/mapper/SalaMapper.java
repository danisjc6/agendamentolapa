package br.edu.ufape.agendamentolapa.mapper;

import br.edu.ufape.agendamentolapa.dto.SalaDTO;
import br.edu.ufape.agendamentolapa.model.Sala;

public class SalaMapper {

    public static SalaDTO toDTO(Sala sala) {

        if (sala == null) {
            return null;
        }

        SalaDTO dto = new SalaDTO();

        dto.setId(sala.getId());
        dto.setNomeSala(sala.getNomeSala());
        dto.setCapacidade(sala.getCapacidade());
        dto.setTipo(sala.getTipo());

        return dto;
    }

    public static Sala toEntity(SalaDTO dto) {

        if (dto == null) {
            return null;
        }

        Sala sala = new Sala();

        sala.setId(dto.getId());
        sala.setNomeSala(dto.getNomeSala());
        sala.setCapacidade(dto.getCapacidade());
        sala.setTipo(dto.getTipo());

        return sala;
    }
}

