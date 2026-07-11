package br.edu.ufape.agendamentolapa.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

    public List<Estudante> listar() {
        return repository.findAll();
    }
}