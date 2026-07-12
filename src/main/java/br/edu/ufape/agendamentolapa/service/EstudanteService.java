package br.edu.ufape.agendamentolapa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.ufape.agendamentolapa.model.Agendamento;
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
 
 	public Optional<Estudante> buscarPorId(Long id) {
 		return repository.findById(id);
 	}
 	
 	 public void excluir(Long id) {
	      repository.deleteById(id);
 	 }
}