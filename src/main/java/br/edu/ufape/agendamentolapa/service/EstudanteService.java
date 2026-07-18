package br.edu.ufape.agendamentolapa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ufape.agendamentolapa.dto.EstudanteDTO;
import br.edu.ufape.agendamentolapa.exception.EntityNotFoundException;
import br.edu.ufape.agendamentolapa.mapper.EstudanteMapper;
import br.edu.ufape.agendamentolapa.model.Estudante;
import br.edu.ufape.agendamentolapa.repository.EstudanteRepository;

@Service
public class EstudanteService {

    private final EstudanteRepository repository;

    public EstudanteService(EstudanteRepository repository) {
        this.repository = repository;
    }

    public Estudante salvar(Estudante estudante) {
        return repository.save(estudante);
    }

    public List<EstudanteDTO> listar() {

        return repository.findAll()
                .stream()
                .map(EstudanteMapper::toDTO)
                .toList();
    }

    public Estudante buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Estudante não encontrado."));
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}