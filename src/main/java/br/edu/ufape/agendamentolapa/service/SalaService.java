package br.edu.ufape.agendamentolapa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ufape.agendamentolapa.dto.SalaDTO;
import br.edu.ufape.agendamentolapa.exception.EntityNotFoundException;
import br.edu.ufape.agendamentolapa.mapper.SalaMapper;
import br.edu.ufape.agendamentolapa.model.Sala;
import br.edu.ufape.agendamentolapa.repository.SalaRepository;

@Service
public class SalaService {

    private final SalaRepository repository;

    public SalaService(SalaRepository repository) {
        this.repository = repository;
    }

    public Sala salvar(Sala sala) {
        return repository.save(sala);
    }
    
    public List<SalaDTO> listar() {

        return repository.findAll()
                .stream()
                .map(SalaMapper::toDTO)
                .toList();
    }
    
    public Sala buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Sala não encontrada."));
 	}
 	
	public void excluir(Long id) {
	    repository.deleteById(id);
	}
}