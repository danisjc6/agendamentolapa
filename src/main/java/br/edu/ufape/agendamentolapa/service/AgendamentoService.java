package br.edu.ufape.agendamentolapa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.edu.ufape.agendamentolapa.model.Agendamento;
import br.edu.ufape.agendamentolapa.repository.AgendamentoRepository;

@Service
public class AgendamentoService {
	
	private final AgendamentoRepository repository;

	public AgendamentoService(AgendamentoRepository repository) {
		this.repository = repository;
	}

	// Salvar ou atualizar
	public Agendamento salvar(Agendamento agendamento) {
		return repository.save(agendamento);
	}

	 // Listar todos
	 public List<Agendamento> listar() {
	    return repository.findAll();
	 }

	  // Buscar por ID
	 public Agendamento buscarPorId(Long id) {
		    return repository.findById(id)
		            .orElseThrow(() ->
		                    new RuntimeException("Agendamento não encontrado."));
	 }

	  // Excluir
	 public void excluir(Long id) {
	     repository.deleteById(id);
	 }
}

