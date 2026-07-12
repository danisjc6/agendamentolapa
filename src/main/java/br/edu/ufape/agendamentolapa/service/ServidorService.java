package br.edu.ufape.agendamentolapa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.ufape.agendamentolapa.model.Servidor;
import br.edu.ufape.agendamentolapa.repository.ServidorRepository;

@Service
public class ServidorService {

    private final ServidorRepository repository;

    public ServidorService(ServidorRepository repository) {
        this.repository = repository;
    }

    public Servidor salvar(Servidor servidor) {
        return repository.save(servidor);
    }

    public List<Servidor> listar() {
        return repository.findAll();
    }
    
    public Optional<Servidor> buscarPorId(Long id) {
		  return repository.findById(id);
	}
    
    public void excluir(Long id) {
	    repository.deleteById(id);
	}
}