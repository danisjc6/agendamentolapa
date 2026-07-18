package br.edu.ufape.agendamentolapa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ufape.agendamentolapa.dto.ServidorDTO;
import br.edu.ufape.agendamentolapa.exception.EntityNotFoundException;
import br.edu.ufape.agendamentolapa.mapper.ServidorMapper;
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

    public List<ServidorDTO> listar() {
        return repository.findAll()
                .stream()
                .map(ServidorMapper::toDTO)
                .toList();
    }

    public Servidor buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Servidor não encontrado."));
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}