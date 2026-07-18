package br.edu.ufape.agendamentolapa.service;

import java.util.List;
import org.springframework.stereotype.Service;

import br.edu.ufape.agendamentolapa.dto.AgendamentoDTO;
import br.edu.ufape.agendamentolapa.exception.BusinessException;
import br.edu.ufape.agendamentolapa.exception.EntityNotFoundException;
import br.edu.ufape.agendamentolapa.mapper.AgendamentoMapper;
import br.edu.ufape.agendamentolapa.model.Agendamento;
import br.edu.ufape.agendamentolapa.model.Pessoa;
import br.edu.ufape.agendamentolapa.model.Sala;
import br.edu.ufape.agendamentolapa.model.Servidor;
import br.edu.ufape.agendamentolapa.repository.AgendamentoRepository;
import br.edu.ufape.agendamentolapa.repository.PessoaRepository;
import br.edu.ufape.agendamentolapa.repository.SalaRepository;
import br.edu.ufape.agendamentolapa.repository.ServidorRepository;


@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final PessoaRepository pessoaRepository;
    private final SalaRepository salaRepository;
    private final ServidorRepository servidorRepository;

    public AgendamentoService(
            AgendamentoRepository repository,
            PessoaRepository pessoaRepository,
            SalaRepository salaRepository,
            ServidorRepository servidorRepository) {

        this.repository = repository;
        this.pessoaRepository = pessoaRepository;
        this.salaRepository = salaRepository;
        this.servidorRepository = servidorRepository;
    }

    // Salvar ou atualizar
    public Agendamento salvar(AgendamentoDTO dto) {

        Pessoa solicitante = pessoaRepository.findById(dto.getSolicitanteId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Solicitante não encontrado."));

        Sala sala = salaRepository.findById(dto.getSalaId())
                .orElseThrow(() ->
                        new EntityNotFoundException("Sala não encontrada."));

        Servidor aprovador = null;

        if (dto.getAprovadorId() != null) {
            aprovador = servidorRepository.findById(dto.getAprovadorId())
                    .orElseThrow(() ->
                            new EntityNotFoundException("Aprovador não encontrado."));
        }

        // Validação dos horários
        if (dto.getHorarioFinal().isBefore(dto.getHorarioInicial())) {
            throw new BusinessException(
                    "O horário final deve ser posterior ao horário inicial.");
        }

        // Validação das datas
        if (dto.getDataFim().isBefore(dto.getDataInicio())) {
            throw new BusinessException(
                    "A data final não pode ser anterior à data inicial.");
        }

        // Verificação de conflito
        List<Agendamento> conflitos =
                repository.verificarConflitos(
                        dto.getSalaId(),
                        dto.getDataInicio(),
                        dto.getHorarioInicial(),
                        dto.getHorarioFinal());

        if (!conflitos.isEmpty()) {
            throw new BusinessException(
                    "Já existe um agendamento para esta sala neste horário.");
        }

        Agendamento agendamento = AgendamentoMapper.toEntity(
                dto,
                solicitante,
                sala,
                aprovador);

        return repository.save(agendamento);
    }

    public List<AgendamentoDTO> listar() {
        return repository.findAll()
                .stream()
                .map(AgendamentoMapper::toDTO)
                .toList();
    }

    public AgendamentoDTO buscarPorId(Long id) {

        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Agendamento não encontrado."));

        return AgendamentoMapper.toDTO(agendamento);
    }
    
    public void excluir(Long id) {

        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(
                    "Agendamento não encontrado.");
        }

        repository.deleteById(id);
    }
    
}