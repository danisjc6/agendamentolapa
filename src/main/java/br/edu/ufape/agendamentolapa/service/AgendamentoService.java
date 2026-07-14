package br.edu.ufape.agendamentolapa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.ufape.agendamentolapa.dto.AgendamentoDTO;
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
                    new RuntimeException("Solicitante não encontrado."));

    Sala sala = salaRepository.findById(dto.getSalaId())
            .orElseThrow(() ->
                    new RuntimeException("Sala não encontrada."));

    Servidor aprovador = null;

    if (dto.getAprovadorId() != null) {

        aprovador = servidorRepository.findById(dto.getAprovadorId())
                .orElseThrow(() ->
                        new RuntimeException("Aprovador não encontrado."));
    }

    Agendamento agendamento = AgendamentoMapper.toEntity(
            dto,
            solicitante,
            sala,
            aprovador);

    return repository.save(agendamento);
}

	 // Listar todos
public List<AgendamentoDTO> listar() {

    return repository.findAll()
            .stream()
            .map(AgendamentoMapper::toDTO)
            .toList();
}

	  // Buscar por ID
public AgendamentoDTO buscarPorId(Long id) {

    Agendamento agendamento = repository.findById(id)
            .orElseThrow(() ->
                    new RuntimeException("Agendamento não encontrado."));

    return AgendamentoMapper.toDTO(agendamento);
}

	  // Excluir
public void excluir(Long id) {
	     repository.deleteById(id);
}
}

