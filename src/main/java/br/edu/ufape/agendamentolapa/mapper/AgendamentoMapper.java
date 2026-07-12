package br.edu.ufape.agendamentolapa.mapper;

import org.springframework.stereotype.Component;
import br.edu.ufape.agendamentolapa.dto.AgendamentoDTO;
import br.edu.ufape.agendamentolapa.model.Agendamento;
import br.edu.ufape.agendamentolapa.model.Pessoa;
import br.edu.ufape.agendamentolapa.model.Sala;

@Component
public class AgendamentoMapper {

    public Agendamento toEntity(AgendamentoDTO dto,
                                Pessoa solicitante,
                                Sala sala) {

        Agendamento agendamento = new Agendamento();

        agendamento.setDataInicio(dto.getDataInicio());
        agendamento.setDataFim(dto.getDataFim());
        agendamento.setHorarioInicial(dto.getHorarioInicial());
        agendamento.setHorarioFinal(dto.getHorarioFinal());
        agendamento.setFinalidade(dto.getFinalidade());
        agendamento.setFrequencia(dto.getFrequencia());

        agendamento.setSolicitante(solicitante);
        agendamento.setSala(sala);

        return agendamento;
    }

    public AgendamentoDTO toDTO(Agendamento agendamento) {

        AgendamentoDTO dto = new AgendamentoDTO();

        dto.setDataInicio(agendamento.getDataInicio());
        dto.setDataFim(agendamento.getDataFim());
        dto.setHorarioInicial(agendamento.getHorarioInicial());
        dto.setHorarioFinal(agendamento.getHorarioFinal());
        dto.setFinalidade(agendamento.getFinalidade());
        dto.setFrequencia(agendamento.getFrequencia());

        dto.setSolicitanteId(agendamento.getSolicitante().getId());
        dto.setSalaId(agendamento.getSala().getId());

        return dto;
    }
}