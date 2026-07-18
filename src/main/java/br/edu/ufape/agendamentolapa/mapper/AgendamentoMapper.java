package br.edu.ufape.agendamentolapa.mapper;

import br.edu.ufape.agendamentolapa.dto.AgendamentoDTO;
import br.edu.ufape.agendamentolapa.model.Agendamento;
import br.edu.ufape.agendamentolapa.model.Pessoa;
import br.edu.ufape.agendamentolapa.model.Sala;
import br.edu.ufape.agendamentolapa.model.Servidor;

public class AgendamentoMapper {

    public static AgendamentoDTO toDTO(Agendamento agendamento) {

        if (agendamento == null)
            return null;

        AgendamentoDTO dto = new AgendamentoDTO();

        dto.setId(agendamento.getId());

        dto.setDataInicio(agendamento.getDataInicio());
        dto.setDataFim(agendamento.getDataFim());

        dto.setHorarioInicial(agendamento.getHorarioInicial());
        dto.setHorarioFinal(agendamento.getHorarioFinal());

        dto.setFinalidade(agendamento.getFinalidade());

        dto.setStatus(agendamento.getStatus());
        dto.setFrequencia(agendamento.getFrequencia());

        dto.setSolicitanteId(agendamento.getSolicitante().getId());
        dto.setSalaId(agendamento.getSala().getId());

        if (agendamento.getAprovador() != null) {
            dto.setAprovadorId(agendamento.getAprovador().getId());
        }

        return dto;
    }

    public static Agendamento toEntity(
            AgendamentoDTO dto,
            Pessoa solicitante,
            Sala sala,
            Servidor aprovador) {

        if (dto == null)
            return null;

        Agendamento agendamento = new Agendamento();

        agendamento.setId(dto.getId());

        agendamento.setDataInicio(dto.getDataInicio());
        agendamento.setDataFim(dto.getDataFim());

        agendamento.setHorarioInicial(dto.getHorarioInicial());
        agendamento.setHorarioFinal(dto.getHorarioFinal());

        agendamento.setFinalidade(dto.getFinalidade());

        agendamento.setFrequencia(dto.getFrequencia());

        if (dto.getStatus() != null) {
            agendamento.setStatus(dto.getStatus());
        } else {
            agendamento.setStatus(Agendamento.StatusAgendamento.SOLICITADO);
        }

        agendamento.setSolicitante(solicitante);
        agendamento.setSala(sala);
        agendamento.setAprovador(aprovador);

        return agendamento;
    	}
    
}