package br.edu.ufape.agendamentolapa.mapper;

import br.edu.ufape.agendamentolapa.dto.SalaDTO;
import br.edu.ufape.agendamentolapa.model.Sala;

public class SalaMapper {
	public Sala toEntity(SalaDTO dto) {

	    Sala sala = new Sala();

	    sala.setNomeSala(dto.getNomeSala());
	    sala.setCapacidade(dto.getCapacidade());
	    sala.setTipo(dto.getTipo());

	    return sala;
	}
}

